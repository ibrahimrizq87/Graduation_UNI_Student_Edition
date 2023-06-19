package com.uni.unistudent.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.uni.unistudent.R
import com.uni.unistudent.adapters.NotificationAdapter

import com.uni.unistudent.classes.Posts
import com.uni.unistudent.databinding.FragmentNotificationsBinding
import java.util.Date

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class NotificationsFragment : Fragment() {
    private lateinit var binding: FragmentNotificationsBinding
    private lateinit var testList: List<Posts>
    private lateinit var notificationAdapter: NotificationAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate<FragmentNotificationsBinding>(
            inflater, R.layout.fragment_notifications, container, false
        )
        //for testing
        testList = listOf(
            Posts("hi this is test post", "fofa", time = Date(2001, 11, 1)),
            Posts("another test post", "bar", time = Date(2021, 5, 15))
        )
        notificationAdapter = NotificationAdapter(testList)
        // Set up the RecyclerView
        binding.recyclerNotifications.apply {
            adapter = notificationAdapter
            layoutManager = LinearLayoutManager(requireContext())



        }
       // setRecycler(testList)
        return binding.root
    }
   /* private fun setRecycler(list: List<Posts>) {
        binding.recyclerNotifications.adapter = NotificationAdapter(list)
        Log.i("Fofa", "list size : ${testList.size}")
    }*/
}