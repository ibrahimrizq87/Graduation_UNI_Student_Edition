package com.uni.unistudent.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.uni.unistudent.R
import com.uni.unistudent.adapters.PostsAdapter
import com.uni.unistudent.classes.Courses
import com.uni.unistudent.classes.Posts
import com.uni.unistudent.classes.user.UserStudent
import com.uni.unistudent.data.Resource
import com.uni.unistudent.data.di.PostType
import com.uni.unistudent.ui.HomeScreen
import com.uni.unistudent.viewModel.AuthViewModel
import com.uni.unistudent.viewModel.FirebaseViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class HomeFragment : Fragment() {
// there is a problem here the list of posts and with the
// modification of data as https://stackoverflow.com/questions/72760708/kotlin-stateflow-not-emitting-updates-to-its-collectors

    private val viewModel: FirebaseViewModel by viewModels()
    private val authViewModel: AuthViewModel by viewModels()
    lateinit var progress: ProgressBar
    lateinit var currentUser: UserStudent
    lateinit var swipeRefreshLayout: SwipeRefreshLayout
    lateinit var coursesList: MutableList<Courses>
    lateinit var adapter: PostsAdapter
    lateinit var postsList: MutableList<Posts>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
// update user data --------------------------------------------------------------------------------
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
        // update user data --------------------------------------------------------------------------------

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.home_recycler)
        progress = view.findViewById(R.id.progress_bar_home)
        swipeRefreshLayout = view.findViewById(R.id.swipe_refresh_layout)


        coursesList = arrayListOf()
        postsList = arrayListOf()


        swipeRefreshLayout.setOnRefreshListener {
            swipeRefreshLayout.isRefreshing = false
            if (currentUser != null) {
                viewModel.getCourses(currentUser.grade)
            }
            /* viewModel.getPosts(
                coursesList,
                currentUser.section,
                currentUser.department,
                currentUser.userId
            )
           postsList.clear()
             if (currentUser!=null){
                 for(co in  coursesList){
                     Log.e("error",co.courseCode)
                 }
                 lifecycleScope.launchWhenCreated {

                     viewModel.getPostsCourse(coursesList)
                 }
                 viewModel.getPostsSection(currentUser.section,currentUser.department)
                 viewModel.getPostsPersonal(currentUser.userId)
             }
             viewModel.getPostsGeneral()

         */

        }

        adapter = PostsAdapter(requireContext(), postsList,
            onItemClicked = { pos, item ->

                Toast.makeText(requireContext(), pos.toString()+" "+item.authorName, Toast.LENGTH_SHORT).show()
            },
            onComment = { pos, item ->
                val bundle = Bundle()
                bundle.putString("postId", item.postID)
                bundle.putString("aud", item.audience)
                if (item.audience == PostType.course) {
                    bundle.putString("course", item.courseID)
                } else {
                    bundle.putString("course", "")
                }
                val commentFragment = CommentFragment()
                commentFragment.arguments = bundle
                (activity as HomeScreen).replaceFragment(commentFragment)
                //Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_commentFragment)


            })


//-------------- setting the recycler data---------------------------//
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
//-------------- setting the recycler data---------------------------//


        /*   if (currentUser!=null){
               viewModel.getPostsSection(currentUser.section,currentUser.department)
               viewModel.getCourses(currentUser.grade)
               viewModel.getPostsPersonal(currentUser.userId)
           }
   */
        // viewModel.getPostsGeneral()
        if (currentUser != null) {
            viewModel.getCourses(currentUser.grade)
        }
        observeCourses()

    }

    private fun observeCourses() {
        lifecycleScope.launchWhenCreated {
            viewModel.getCourses.collectLatest { state ->
                when (state) {
                    is Resource.Loading -> {
                        progress.visibility = View.VISIBLE

                    }

                    is Resource.Success -> {

                        state.result.forEach {
                            Log.e("MNB", it.courseCode)
                            coursesList.add(it)
                        }
                        //viewModel.getPostsCourse(coursesList)
                        viewModel.getPosts(
                            coursesList,
                            currentUser.section,
                            currentUser.department,
                            currentUser.userId
                        )
                        progress.visibility = View.VISIBLE
                        // ---------------------------- wait until the data is updated because of the delay done because of the loops---------------------//
                        delay(200)
                        // ---------------------------- wait until the data is updated because of the delay done because of the loops---------------------//
                        progress.visibility = View.GONE
                        observe()
                        // observePosts()

                    }

                    is Resource.Failure -> {
                        progress.visibility = View.GONE
                        Toast.makeText(context, state.exception.toString(), Toast.LENGTH_LONG)
                            .show()
                    }

                    else -> {}
                }
            }
        }
    }

    private fun observe() {
        lifecycleScope.launchWhenCreated {
            viewModel.getPosts.collectLatest { state ->
                when (state) {
                    is Resource.Loading -> {
                        Log.e("vvvvvvvv", "ererroe")
                        progress.visibility = View.VISIBLE
                    }

                    is Resource.Success -> {
                        postsList.clear()
                        state.result.forEach {
                            if (it.imageUrl != null) {
                                it.type = PostsAdapter.WITH_IMAGE
                            } else {
                                it.type = PostsAdapter.WITHOUT_IMAGE
                            }
                            postsList.add(it)
                        }
                        adapter.update(postsList)
                    }

                    is Resource.Failure -> {
                        progress.visibility = View.GONE
                        Toast.makeText(context, state.exception.toString(), Toast.LENGTH_LONG)
                            .show()
                    }

                    else -> {}
                }
            }
        }
    }

    private fun observePosts() {
        lifecycleScope.launchWhenCreated {
            viewModel.getPostsCourse.collectLatest { state ->
                when (state) {
                    is Resource.Loading -> {
                        Log.e("cefevwgwrgB", "visable")
                        progress.visibility = View.VISIBLE

                    }

                    is Resource.Success -> {
                        state.result.forEach {
                            if (it.imageUrl != null) {
                                it.type = PostsAdapter.WITH_IMAGE
                            } else {
                                it.type = PostsAdapter.WITHOUT_IMAGE
                            }
                            Log.e("MNB", it.audience)

                            postsList.add(it)
                        }
                        adapter.update(postsList)
                    }

                    is Resource.Failure -> {
                        progress.visibility = View.GONE
                        Toast.makeText(context, state.exception.toString(), Toast.LENGTH_LONG)
                            .show()
                    }

                    else -> {}
                }
            }
        }






        lifecycleScope.launchWhenCreated {
            viewModel.getPostsGeneral.collectLatest { state ->
                when (state) {
                    is Resource.Loading -> {
                        progress.visibility = View.VISIBLE

                    }

                    is Resource.Success -> {

                        state.result.forEach {
                            if (it.imageUrl != null) {
                                it.type = PostsAdapter.WITH_IMAGE
                            } else {
                                it.type = PostsAdapter.WITHOUT_IMAGE
                            }
                            Log.e("MNB", it.audience)

                            postsList.add(it)
                        }
                        adapter.update(postsList)

                    }

                    is Resource.Failure -> {
                        progress.visibility = View.GONE
                        Toast.makeText(context, state.exception.toString(), Toast.LENGTH_LONG)
                            .show()
                    }

                    else -> {}
                }
            }
        }



        lifecycleScope.launchWhenCreated {
            viewModel.getPostsSection.collectLatest { state ->
                when (state) {
                    is Resource.Loading -> {
                        progress.visibility = View.VISIBLE

                    }

                    is Resource.Success -> {

                        state.result.forEach {
                            if (it.imageUrl != null) {
                                it.type = PostsAdapter.WITH_IMAGE
                            } else {
                                it.type = PostsAdapter.WITHOUT_IMAGE
                            }
                            postsList.add(it)
                            Log.e("MNB", it.audience)

                        }
                        adapter.update(postsList)
                    }

                    is Resource.Failure -> {
                        progress.visibility = View.GONE
                        Toast.makeText(context, state.exception.toString(), Toast.LENGTH_LONG)
                            .show()
                    }

                    else -> {}
                }
            }
        }




        lifecycleScope.launchWhenCreated {
            viewModel.getPostsPersonal.collectLatest { state ->
                when (state) {
                    is Resource.Loading -> {
                        progress.visibility = View.VISIBLE

                    }

                    is Resource.Success -> {

                        state.result.forEach {
                            if (it.imageUrl != null) {
                                it.type = PostsAdapter.WITH_IMAGE
                            } else {
                                it.type = PostsAdapter.WITHOUT_IMAGE
                            }
                            postsList.add(it)
                            Log.e("MNB", it.audience)

                        }
                        adapter.update(postsList)

                    }

                    is Resource.Failure -> {
                        progress.visibility = View.GONE
                        Toast.makeText(context, state.exception.toString(), Toast.LENGTH_LONG)
                            .show()
                    }

                    else -> {}
                }
            }
        }
        adapter.update(postsList)

    }
}














