package com.uni.unistudent.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uni.unistudent.R
import com.uni.unistudent.adapters.ScheduleAdapter
import com.uni.unistudent.classes.Courses
import com.uni.unistudent.classes.ScheduleDataType
import com.uni.unistudent.classes.user.UserStudent
import com.uni.unistudent.data.Resource
import com.uni.unistudent.viewModel.AuthViewModel
import com.uni.unistudent.viewModel.FirebaseViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest


@AndroidEntryPoint
class ScheduleFragment : Fragment() {

    private val viewModel: FirebaseViewModel by viewModels()
    private val authViewModel: AuthViewModel by viewModels()
    lateinit var progress:ProgressBar
    lateinit var currentUser:UserStudent

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
        val up = view.findViewById<Button>(R.id.update)
         progress= view.findViewById<ProgressBar>(R.id.progress_par)
up.setOnClickListener {
    observeLectures()
    observeSections()
}
        coursesList= arrayListOf()
        scheduleDataType= arrayListOf()

        adapter= ScheduleAdapter(requireContext(),scheduleDataType,

            onItemClicked = {pos, item->
                Toast.makeText(requireContext(),item.professorName,Toast.LENGTH_SHORT).show()
            }
            ,
            onAttendClicked = { pos, item ->
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
                Log.e("SSSSSS","here1")
                when (state) {
                    is Resource.Loading -> {
                        progress.visibility=View.VISIBLE

                    }
                    is Resource.Success -> {
                        progress.visibility=View.INVISIBLE

                        state.result.forEach {
                            Log.e("SSSSSS",it.courseCode)
                            scheduleDataType.add(ScheduleDataType(
                                it.courseName,
                                it.lapID,
                                it.assistantName,
                                it.day,
                                it.time,
                                it.endTime,
                                ScheduleAdapter.VIEW_TYPE_ONE
                            ))
                        }
                        adapter.update(scheduleDataType)

                    }
                    is Resource.Failure -> {
                        progress.visibility=View.INVISIBLE
                        Toast.makeText(context,state.exception.toString(),Toast.LENGTH_LONG).show()
                    }
                    else->{Log.e("VVVV","else")}
                }}}

    }

    private fun observeLectures() {
        lifecycleScope.launchWhenCreated {
            viewModel.getLecture.collectLatest { state ->
                Log.e("lllllllllllllllll","here1")

                when (state) {
                    is Resource.Loading -> {
                        progress.visibility=View.VISIBLE

                    }
                    is Resource.Success -> {
                        progress.visibility=View.INVISIBLE
                        Log.e("lllllll","here2")
                        Log.e("lllllll", state.result.count().toString())
                        state.result.forEach {
                            Log.e("MMMMM",it.courseCode)
                            scheduleDataType.add(ScheduleDataType(
                                it.courseName,
                                it.hallID,
                                it.professorName,
                                it.day,
                                it.time,
                                it.endTime,
                                ScheduleAdapter.VIEW_TYPE_TWO
                            ))
                        }
                        adapter.update(scheduleDataType)
                    }
                    is Resource.Failure -> {
                        progress.visibility=View.INVISIBLE
                        Toast.makeText(context,state.exception.toString(),Toast.LENGTH_LONG).show()
                    }
                    else->{Log.e("VVVV","else")}
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
            progress.visibility=View.INVISIBLE

            state.result.forEach {
                Log.e("VVVV",it.courseCode)
             coursesList.add(it)
            }
            viewModel.getSection(coursesList,currentUser.department,currentUser.section)
            viewModel.getLecture(coursesList,currentUser.department)
            observeLectures()
            observeSections()

        }
        is Resource.Failure -> {
            progress.visibility=View.INVISIBLE
            Toast.makeText(context,state.exception.toString(),Toast.LENGTH_LONG).show()
        }
        else->{Log.e("VVVV","else")}
}
        }
    }}}
