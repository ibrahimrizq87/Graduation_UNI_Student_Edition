package com.uni.unistudent.ui.fragments
import android.content.Intent
import android.hardware.biometrics.BiometricManager
import android.hardware.biometrics.BiometricManager.Authenticators.DEVICE_CREDENTIAL
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.biometric.BiometricManager.Authenticators.BIOMETRIC_STRONG
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uni.unistudent.R
import com.uni.unistudent.adapters.DaysAdapter
import com.uni.unistudent.adapters.ScheduleAdapter
import com.uni.unistudent.classes.Courses
import com.uni.unistudent.classes.ScheduleDataType
import com.uni.unistudent.classes.user.UserStudent
import com.uni.unistudent.data.Resource
import com.uni.unistudent.databinding.FragmentScheduleBinding
import com.uni.unistudent.ui.Scan
import com.uni.unistudent.viewModel.AuthViewModel
import com.uni.unistudent.viewModel.FirebaseViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import java.util.concurrent.Executor
@AndroidEntryPoint
class ScheduleFragment : Fragment(), DaysAdapter.CustomClickListener {

    private lateinit var binding: FragmentScheduleBinding
    private val viewModel: FirebaseViewModel by viewModels()
    private val authViewModel: AuthViewModel by viewModels()
    lateinit var progress: ProgressBar
    lateinit var currentUser: UserStudent
    private lateinit var daySelected: MutableLiveData<String>
    lateinit var coursesList: MutableList<Courses>

    lateinit var adapter: ScheduleAdapter
    lateinit var scheduleDataType: MutableList<ScheduleDataType>

    private var isLecLoaded = false
    private var isSecLoaded = false
    private var isCorLoaded = false
    private var hasBiomatric = false
    private lateinit var biometricPrompt: BiometricPrompt
    private lateinit var executor: Executor
    private lateinit var promptInfo: BiometricPrompt.PromptInfo
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentScheduleBinding.inflate(layoutInflater)
        authViewModel.getSessionStudent { user ->
            if (user != null) {
                currentUser = user
            } else {
                Toast.makeText(
                    context,
                    "error on loading user data please refresh the current screen ",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        //++++++++++++++biomatric+++++++++++++++//
        executor = context?.let { ContextCompat.getMainExecutor(it) }!!
        biometricPrompt = BiometricPrompt(
            requireActivity(),
            executor,
            object : BiometricPrompt.AuthenticationCallback() {
                override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                    super.onAuthenticationSucceeded(result)

                    val intent = Intent(requireContext(), Scan::class.java)
                    startActivity(intent)


                }

                override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                    super.onAuthenticationError(errorCode, errString)
                    Toast.makeText(context, "Authentication error $errString", Toast.LENGTH_SHORT)
                        .show()
                }

                override fun onAuthenticationFailed() {
                    super.onAuthenticationFailed()
                    Toast.makeText(context, "Authentication Failed", Toast.LENGTH_SHORT).show()
                }
            })
        promptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle("Verify your identity")
            .setSubtitle("To take attend")
            .setNegativeButtonText("Cancel")
            .build()


        //++++++++++++++++++++++++++++++++//

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        coursesList = arrayListOf()
        scheduleDataType = arrayListOf()
        daySelected = MutableLiveData()


        val recyclerView = view.findViewById<RecyclerView>(R.id.schedule_recycler)
        progress = view.findViewById(R.id.progress_bar)
        checkDeviceHasBiomatric()
        //-------------- setting the recycler data---------------------------//
        binding.recyclerDays.layoutManager =
            LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerDays.adapter = DaysAdapter(this, requireContext())

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        //-------------- setting the recycler data---------------------------//

        //+++++++++++++++++++biomatric++++++++++++++++++++++++//


        //+++++++++++++++++++++++++++++++++++++++++++++++++++//

        adapter = ScheduleAdapter(requireContext(), scheduleDataType,
            onItemClicked = { pos, item ->
                Toast.makeText(requireContext(), item.professorName, Toast.LENGTH_SHORT).show()
            }, onAttendClicked = { pos, item ->
if (item.hasRunning){

    val intent = Intent(requireContext(), Scan::class.java)
    if (item.type == ScheduleAdapter.VIEW_TYPE_ONE) {
        intent.putExtra("course", item.courseID)
        intent.putExtra("dep", item.dep)
        intent.putExtra("section", item.section)
        intent.putExtra("id", item.eventId)

    } else {


        intent.putExtra("course", item.courseID)
        intent.putExtra("dep", item.dep)
        intent.putExtra("section", "no")
        intent.putExtra("id", item.eventId)

    }
    startActivity(intent)
}else{
    Toast.makeText(context,"did not started yet",Toast.LENGTH_SHORT).show()
}
            })
        //-------------- setting the recycler data---------------------------//
        recyclerView.adapter = adapter
        //-------------- setting the recycler data---------------------------//
        //---------------------- getting the required data ---------------------------//
        viewModel.getCourses(currentUser.grade)
        observeCourses()
        //---------------------- getting the required data ---------------------------//

        daySelected.observe(viewLifecycleOwner) { it2 ->
            val scheduleDataType =
                scheduleDataType.filter { it.day == it2 } as MutableList<ScheduleDataType>
            if (scheduleDataType.size == 0) {
                binding.imageEmptySchedule.visibility = View.VISIBLE
            } else {
                binding.imageEmptySchedule.visibility = View.GONE
            }
            adapter.update(scheduleDataType)
            adapter.notifyDataSetChanged()
        }
    }

    private fun checkDeviceHasBiomatric() {
        val biometricManager = context?.let { androidx.biometric.BiometricManager.from(it) }
        if (biometricManager != null) {
            when (biometricManager.canAuthenticate(BIOMETRIC_STRONG or androidx.biometric.BiometricManager.Authenticators.DEVICE_CREDENTIAL)) {
                androidx.biometric.BiometricManager.BIOMETRIC_SUCCESS -> {
                    hasBiomatric = true
                }

                androidx.biometric.BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE -> {
                    hasBiomatric = false
                }

                androidx.biometric.BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED -> {
                    val intent = Intent(Settings.ACTION_BIOMETRIC_ENROLL).apply {
                        putExtra(
                            Settings.EXTRA_BIOMETRIC_AUTHENTICATORS_ALLOWED,
                            BIOMETRIC_STRONG or DEVICE_CREDENTIAL
                        )
                    }
                    hasBiomatric = false
                    startActivityForResult(intent, 10121)
                }
            }
        }
    }

    private fun observeSections() {
        lifecycleScope.launchWhenCreated {
            viewModel.getSection.collectLatest { state ->
                when (state) {
                    is Resource.Loading -> {
                        progress.visibility = View.VISIBLE
                        binding.imageEmptySchedule.visibility = View.GONE
                    }

                    is Resource.Success -> {
                        isSecLoaded = true
                        if (isLecLoaded && isCorLoaded) {
                            progress.visibility = View.GONE
                        }
                        state.result.forEach {
                            val item = ScheduleDataType(
                                it.sectionId,
                                it.courseName,
                                it.courseCode,
                                it.lapID,
                                it.section,
                                it.dep,
                                it.assistantName,
                                it.day,
                                it.time,
                                it.endTime,
                                ScheduleAdapter.VIEW_TYPE_ONE,
                                it.hasRunning
                            )
                            scheduleDataType.add(item)


                        }
                        daySelected.postValue("Saturday")
                    }

                    is Resource.Failure -> {
                        progress.visibility = View.INVISIBLE
                        Toast.makeText(context, state.exception.toString(), Toast.LENGTH_LONG)
                            .show()
                    }

                    else -> {
                    }
                }
            }
        }

    }

    private fun observeLectures() {
        lifecycleScope.launchWhenCreated {
            viewModel.getLecture.collectLatest { state ->

                when (state) {
                    is Resource.Loading -> {
                        progress.visibility = View.VISIBLE
                        binding.imageEmptySchedule.visibility = View.GONE
                    }

                    is Resource.Success -> {
                        isLecLoaded = true
                        if (isSecLoaded && isCorLoaded) {
                            progress.visibility = View.GONE
                        }

                        state.result.forEach {

                            val item = ScheduleDataType(
                                it.lectureId,
                                it.courseName,
                                it.courseCode,
                                it.hallID,
                                "",
                                it.dep,
                                it.professorName,
                                it.day,
                                it.time,
                                it.endTime,
                                ScheduleAdapter.VIEW_TYPE_ONE,
                                it.hasRunning
                            )
                            scheduleDataType.add(item)
                        }

                        daySelected.postValue("Sat")

                    }

                    is Resource.Failure -> {
                        progress.visibility = View.INVISIBLE
                        Toast.makeText(context, state.exception.toString(), Toast.LENGTH_LONG)
                            .show()
                    }

                    else -> {
                    }
                }
            }
        }
    }

    private fun observeCourses() {
        lifecycleScope.launchWhenCreated {
            viewModel.getCourses.collectLatest { state ->
                when (state) {
                    is Resource.Loading -> {
                        progress.visibility = View.VISIBLE
                        binding.imageEmptySchedule.visibility = View.INVISIBLE
                    }

                    is Resource.Success -> {
                        isCorLoaded = true
                        if (isSecLoaded && isLecLoaded) {
                            progress.visibility = View.GONE
                        }
                        state.result.forEach {
                            coursesList.add(it)
                        }
                        viewModel.getSection(
                            coursesList,
                            currentUser.department,
                            currentUser.section
                        )
                        viewModel.getLecture(coursesList, currentUser.department)
                        delay(1000)
                        observeLectures()
                        observeSections()
                    }

                    is Resource.Failure -> {
                        progress.visibility = View.INVISIBLE
                        Toast.makeText(context, state.exception.toString(), Toast.LENGTH_LONG)
                            .show()
                    }

                    else -> {
                    }
                }
            }
        }
    }

    override fun onCustomClick(day: String) {
        daySelected.postValue(day)
    }
}
