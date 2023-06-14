package com.uni.unistudent.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.uni.unistudent.R
import com.uni.unistudent.adapters.ScheduleAdapter
import com.uni.unistudent.classes.Courses
import com.uni.unistudent.classes.ScheduleDataType
import com.uni.unistudent.classes.user.UserStudent
import com.uni.unistudent.data.Resource
import com.uni.unistudent.viewModel.AuthViewModel
import com.uni.unistudent.viewModel.FirebaseViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import java.util.*


@AndroidEntryPoint
class ScheduleFragment : Fragment() {

    private val viewModel: FirebaseViewModel by viewModels()
    private val authViewModel: AuthViewModel by viewModels()
    lateinit var progress:ProgressBar
    lateinit var currentUser: UserStudent

    lateinit var coursesList:MutableList<Courses>

    lateinit var  adapter : ScheduleAdapter
    lateinit var scheduleDataType:MutableList<ScheduleDataType>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        authViewModel.getSessionStudent {user->
            if (user !=null){
                currentUser=user
                Toast.makeText(context,currentUser.name, Toast.LENGTH_LONG).show()
                }
            else{
                Toast.makeText(context,"error on loading user data please refresh the current screen ", Toast.LENGTH_LONG).show()
            }
        }
        return inflater.inflate(R.layout.fragment_schedule, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView=view.findViewById<RecyclerView>(R.id.schedule_recycler)
         progress= view.findViewById<ProgressBar>(R.id.progress_par)

        //val swipeRefreshLayout = view.findViewById<SwipeRefreshLayout>(R.id.)

        /*
        // TODO solve duplicated data problem
        swipeRefreshLayout.setOnRefreshListener {

            swipeRefreshLayout.isRefreshing = false
            scheduleDataType.clear()
            if (currentUser!=null){
                viewModel.getCourses(currentUser.grade)
            }
        }*/
        // solved by the delay function
        //  another way to solve it is https://stackoverflow.com/questions/75442594/emitting-ui-state-while-collecting-does-not-update-ui
       /* up.setOnClickListener {
            observeLectures()
            observeSections()
}*/
        coursesList= arrayListOf()
        scheduleDataType= arrayListOf()

        adapter= ScheduleAdapter(requireContext(),scheduleDataType,

            onItemClicked = {pos, item->
                Toast.makeText(requireContext(),item.professorName,Toast.LENGTH_SHORT).show()
            }
            ,
            onAttendClicked = { pos, item ->
if (scheduleDataType[pos].isRunning){
    val bundle=Bundle()
    bundle.putString("id",item.eventId)
    val attendanceFragment=AttendanceFragment()
    attendanceFragment.arguments=bundle
    Navigation.findNavController(view).navigate(R.id.action_scheduleFragment_to_attendanceFragment)
}else{
    Toast.makeText(context,"wait for the lecturer to be arrived",Toast.LENGTH_LONG).show()
}
    })


//-------------- setting the recycler data---------------------------//
        recyclerView.layoutManager= LinearLayoutManager(requireContext())
        recyclerView.adapter=adapter
//-------------- setting the recycler data---------------------------//



//---------------------- getting the required data ---------------------------//
        viewModel.getCourses(currentUser.grade)
        observeCourses()



    }

    private fun observeSections() {
        lifecycleScope.launchWhenCreated {
            viewModel.getSection.collectLatest { state ->
                when (state) {
                    is Resource.Loading -> {
                        progress.visibility=View.VISIBLE

                    }
                    is Resource.Success -> {
                        progress.visibility=View.INVISIBLE

                        state.result.forEach {
                            scheduleDataType.add(ScheduleDataType(
                                it.sectionId,
                                it.courseName,
                                it.lapID,
                                it.assistantName,
                                it.day,
                                it.time,
                                it.endTime,
                                ScheduleAdapter.VIEW_TYPE_ONE,
                                it.isRunning
                            ))
                        }
                        adapter.update(scheduleDataType)

                    }
                    is Resource.Failure -> {
                        progress.visibility=View.INVISIBLE
                        Toast.makeText(context,state.exception.toString(),Toast.LENGTH_LONG).show()
                    }
                    else->{}
                }}}

    }




    private fun observeLectures() {
        lifecycleScope.launchWhenCreated {
            viewModel.getLecture.collectLatest { state ->

                when (state) {
                    is Resource.Loading -> {
                        progress.visibility=View.VISIBLE

                    }
                    is Resource.Success -> {
                        progress.visibility=View.INVISIBLE
                        state.result.forEach {
                            scheduleDataType.add(ScheduleDataType(
                                it.lectureId,
                                it.courseName,
                                it.hallID,
                                it.professorName,
                                it.day,
                                it.time,
                                it.endTime,
                                ScheduleAdapter.VIEW_TYPE_TWO,
                                it.isRunning

                            ))
                        }
                        adapter.update(scheduleDataType)
                    }
                    is Resource.Failure -> {
                        progress.visibility=View.INVISIBLE
                        Toast.makeText(context,state.exception.toString(),Toast.LENGTH_LONG).show()
                    }
                    else->{}
                }}}
    }

    private fun observeCourses() {
        lifecycleScope.launchWhenCreated {
        viewModel.getCourses.collectLatest { state ->
    when (state) {
        is Resource.Loading -> {
            progress.visibility=View.VISIBLE

        }
        is Resource.Success -> {

            state.result.forEach {
             coursesList.add(it)
            }
            viewModel.getSection(coursesList,currentUser.department,currentUser.section)
            viewModel.getLecture(coursesList,currentUser.department)
            progress.visibility=View.VISIBLE
            // ---------------------------- wait until the data is updated because of the delay done because of the loops---------------------//
            delay(200)
            // ---------------------------- wait until the data is updated because of the delay done because of the loops---------------------//
            progress.visibility=View.INVISIBLE

            observeLectures()
            observeSections()

        }
        is Resource.Failure -> {
            progress.visibility=View.INVISIBLE
            Toast.makeText(context,state.exception.toString(),Toast.LENGTH_LONG).show()
        }
        else->{}
}
        }
    }}}
