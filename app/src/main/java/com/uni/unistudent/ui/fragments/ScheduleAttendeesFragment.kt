package com.uni.unistudent.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uni.unistudent.R
import com.uni.unistudent.adapters.DaysAdapter
import com.uni.unistudent.adapters.ScheduleAdapter
import com.uni.unistudent.classes.Courses
import com.uni.unistudent.classes.ScheduleDataType
import com.uni.unistudent.classes.user.UserStudent
import com.uni.unistudent.data.Resource
import com.uni.unistudent.databinding.FragmentScheduleAttendeesBinding
import com.uni.unistudent.viewModel.AuthViewModel
import com.uni.unistudent.viewModel.FirebaseViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest


@AndroidEntryPoint
class ScheduleAttendeesFragment : Fragment(), DaysAdapter.CustomClickListener {

    private lateinit var binding: FragmentScheduleAttendeesBinding
    private val viewModel: FirebaseViewModel by viewModels()
    private val authViewModel: AuthViewModel by viewModels()
    lateinit var progress: ProgressBar
    lateinit var currentUser: UserStudent
    private var daySelected = MutableLiveData("Saturday")
    lateinit var coursesList: MutableList<Courses>

    lateinit var adapter: ScheduleAdapter
    lateinit var scheduleDataType: MutableList<ScheduleDataType>

    private var isLecLoaded = false
    private var isSecLoaded = false
    private var isCorLoaded = false


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentScheduleAttendeesBinding.inflate(layoutInflater)
        authViewModel.getSessionStudent { user ->
            if (user != null) {
                currentUser = user
                //Toast.makeText(context, currentUser.name, Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(
                    context,
                    "error on loading user data please refresh the current screen ",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.schedule_recycler)
        // val up = view.findViewById<Button>(R.id.update)
        progress = view.findViewById(R.id.progress_bar)


        // solved by the delay function
        //  another way to solve it is https://stackoverflow.com/questions/75442594/emitting-ui-state-while-collecting-does-not-update-ui
        /* up.setOnClickListener {
             observeLectures()
             observeSections()
 }*/
        coursesList = arrayListOf()
        scheduleDataType = arrayListOf()


        binding.recyclerDays.layoutManager =
            LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerDays.adapter = DaysAdapter(this, requireContext())

        /*
        viewModel.scheduleMap.observe(viewLifecycleOwner, Observer {
            daySelected.observe(viewLifecycleOwner) { it2 ->
                //TODO HERE FILTER THE COURSES
              //  adapter.setScheduleList(it, it2)
                if (it[it2]?.size == null) {
                    binding.imageEmptySchedule.visibility = View.VISIBLE
                } else {
                    binding.imageEmptySchedule.visibility = View.GONE
                }
            }

        })*/

        adapter = ScheduleAdapter(requireContext(), scheduleDataType,
            onItemClicked = { pos, item ->

                Toast.makeText(requireContext(), item.professorName, Toast.LENGTH_SHORT).show()


            }, onAttendClicked = { pos, item ->
                if (scheduleDataType[pos].isRunning) {
                    val bundle = Bundle()
                    bundle.putString("id", item.eventId)
                    val attendanceFragment = ScheduleAttendeesFragment()
                    attendanceFragment.arguments = bundle
                    Navigation.findNavController(view)
                        .navigate(R.id.action_scheduleFragment_to_attendanceFragment)

                } else {

                    Toast.makeText(
                        context,
                        "wait for the lecturer to be arrived",
                        Toast.LENGTH_LONG
                    ).show()

                }
            })


//-------------- setting the recycler data---------------------------//
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
//-------------- setting the recycler data---------------------------//


//---------------------- getting the required data ---------------------------//
        viewModel.getCourses(currentUser.grade)
        observeCourses()


    }

    private fun observeSections() {
        lifecycleScope.launchWhenCreated {
            viewModel.getSection.collectLatest { state ->
                Log.e("SSSSSS", "here1")
                when (state) {
                    is Resource.Loading -> {
                        progress.visibility = View.VISIBLE

                    }

                    is Resource.Success -> {
                        isSecLoaded = true
                        if (isLecLoaded &&isCorLoaded ){
                            progress.visibility = View.GONE
                        }


                        state.result.forEach {
                            Log.e("SSSSSS", it.courseCode)
                            scheduleDataType.add(
                                ScheduleDataType(
                                    it.sectionId,
                                    it.courseName,
                                    it.lapID,
                                    it.assistantName,
                                    it.day,
                                    it.time,
                                    it.endTime,
                                    ScheduleAdapter.VIEW_TYPE_ONE,
                                    it.isRunning
                                )
                            )
                        }
                        adapter.update(scheduleDataType)

                    }

                    is Resource.Failure -> {
                        progress.visibility = View.INVISIBLE
                        Toast.makeText(context, state.exception.toString(), Toast.LENGTH_LONG)
                            .show()
                    }

                    else -> {
                        Log.e("VVVV", "else")
                    }
                }
            }
        }

    }

    private fun observeLectures() {
        lifecycleScope.launchWhenCreated {
            viewModel.getLecture.collectLatest { state ->
                Log.e("lllllllllllllllll", "here1")

                when (state) {
                    is Resource.Loading -> {
                        progress.visibility = View.VISIBLE

                    }

                    is Resource.Success -> {
                        isLecLoaded = true
                        if (isSecLoaded  &&isCorLoaded ){
                            progress.visibility = View.GONE
                        }
                        Log.e("lllllll", "here2")
                        Log.e("lllllll", state.result.count().toString())
                        state.result.forEach {
                            Log.e("MMMMM", it.courseCode)
                            scheduleDataType.add(
                                ScheduleDataType(
                                    it.lectureId,
                                    it.courseName,
                                    it.hallID,
                                    it.professorName,
                                    it.day,
                                    it.time,
                                    it.endTime,
                                    ScheduleAdapter.VIEW_TYPE_TWO,
                                    it.isRunning

                                )
                            )
                        }
                        adapter.update(scheduleDataType)
                    }

                    is Resource.Failure -> {
                        progress.visibility = View.INVISIBLE
                        Toast.makeText(context, state.exception.toString(), Toast.LENGTH_LONG)
                            .show()
                    }

                    else -> {
                        Log.e("VVVV", "else")
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

                    }

                    is Resource.Success -> {
                        isCorLoaded =true
                        if (isSecLoaded &&isLecLoaded ){
                            progress.visibility = View.GONE
                        }

                        state.result.forEach {

                            Log.e("VVVV", it.courseCode)
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
                        Log.e("VVVV", "else")
                    }
                }
            }
        }
    }

    override fun onCustomClick(day: String) {
        daySelected.postValue(day)
    }
}
