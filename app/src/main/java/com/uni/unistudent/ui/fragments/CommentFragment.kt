package com.uni.unistudent.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.uni.unistudent.R
import com.uni.unistudent.adapters.CommentAdapter
import com.uni.unistudent.adapters.PostsAdapter
import com.uni.unistudent.classes.Comment
import com.uni.unistudent.classes.Courses
import com.uni.unistudent.classes.MyComments
import com.uni.unistudent.classes.Posts
import com.uni.unistudent.classes.user.UserStudent
import com.uni.unistudent.data.Resource
import com.uni.unistudent.data.di.PostType
import com.uni.unistudent.databinding.FragmentCommentBinding
import com.uni.unistudent.ui.HomeScreen
import com.uni.unistudent.viewModel.AuthViewModel
import com.uni.unistudent.viewModel.FirebaseViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import java.util.*

@AndroidEntryPoint
class CommentFragment : Fragment() {

    private val viewModel: FirebaseViewModel by viewModels()
    private val authViewModel: AuthViewModel by viewModels()
    private lateinit var progress: ProgressBar
    private lateinit var currentUser: UserStudent

    private lateinit var postID: String
    private lateinit var courseID: String
    private lateinit var commentText: EditText
    private lateinit var aud: String

    private lateinit var adapter: CommentAdapter
    private lateinit var commentList: MutableList<MyComments>

    private lateinit var binding: FragmentCommentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCommentBinding.inflate(layoutInflater)
        //++++++++++++++++++++++++++//
        val bottomNavigationView =  (activity as HomeScreen).findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.visibility = View.GONE
        binding.backFragmentBtn.setOnClickListener {
            parentFragmentManager.popBackStack()
            bottomNavigationView.visibility = View.VISIBLE

        }
        //+++++++++++++++++++++++++//
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

        val recyclerView = binding.commentRecycler
        progress = binding.progressBarComment
        commentList = arrayListOf()

        adapter = CommentAdapter(requireContext(), commentList,

            onUpdate = { pos, comment ->
                val com = Comment(
                    comment.commentID,
                    currentUser.userId,
                    comment.description,
                    currentUser.name,
                    currentUser.code,
                    comment.time
                )

                when (aud) {
                    PostType.course -> {
                        viewModel.deleteCommentsCourse(com, postID, courseID)
                    }

                    PostType.personal_posts -> {
                        viewModel.deleteCommentsPersonal(com, postID, currentUser.userId)
                    }

                    PostType.section_posts -> {
                        viewModel.deleteCommentsSection(
                            com,
                            postID,
                            currentUser.section,
                            currentUser.department
                        )
                    }

                    PostType.general -> {
                        viewModel.deleteCommentsGeneral(com, postID)
                    }

                }
                commentText.setText(comment.description)
            }, onDelete = { pos, comment ->

                val com = Comment(
                    comment.commentID,
                    currentUser.userId,
                    comment.description,
                    currentUser.name,
                    currentUser.code,
                    comment.time
                )
                when (aud) {
                    PostType.course -> {
                        viewModel.deleteCommentsCourse(com, postID, courseID)
                    }

                    PostType.personal_posts -> {
                        viewModel.deleteCommentsPersonal(com, postID, currentUser.userId)
                    }

                    PostType.section_posts -> {
                        viewModel.deleteCommentsSection(
                            com,
                            postID,
                            currentUser.section,
                            currentUser.department
                        )
                    }

                    PostType.general -> {
                        viewModel.deleteCommentsGeneral(com, postID)
                    }
                }
                observeDeletedComment()
            })

        val args = this.arguments
        if (args != null) {

            postID = args.getString("postId", "")
            aud = args.getString("aud", "")
            courseID = args.getString("course", "")
        }

        when (aud) {
            PostType.course -> {
                viewModel.getCommentsCourse(postID, courseID)
            }

            PostType.personal_posts -> {
                viewModel.getCommentsPersonal(postID, currentUser.userId)
            }

            PostType.section_posts -> {
                viewModel.getCommentsSection(postID, currentUser.section, currentUser.department)
            }

            PostType.general -> {
                viewModel.getCommentsGeneral(postID)

            }

        }
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        if (commentList.size == 0) {
            binding.NoCommentsYet.visibility = View.VISIBLE
        } else {
            binding.NoCommentsYet.visibility = View.GONE
        }
        observeCommentGeneral()
        return binding.root
    }

    private fun observeDeletedComment() {
        lifecycleScope.launchWhenCreated {
            viewModel.addCommentGeneral.collectLatest { state ->
                when (state) {
                    is Resource.Loading -> {
                        progress.visibility = View.VISIBLE

                    }

                    is Resource.Success -> {
                        progress.visibility = View.GONE
                        Toast.makeText(context, state.result, Toast.LENGTH_SHORT).show()
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val send = view.findViewById<ImageButton>(R.id.send_comment_bt)
        commentText = view.findViewById(R.id.comment_ed_text)
        var comment = ""
        send.setOnClickListener {
            comment = commentText.text.toString()
            commentText.text.clear()
            when (aud) {
                PostType.course -> {
                    viewModel.addCommentsCourse(
                        Comment(
                            "",
                            currentUser.userId,
                            comment,
                            currentUser.name,
                            currentUser.code,
                            Date()
                        ),
                        postID,
                        courseID
                    )

                }

                PostType.personal_posts -> {
                    viewModel.addCommentsPersonal(
                        Comment(
                            "",
                            currentUser.userId,
                            comment,
                            currentUser.name,
                            currentUser.code,
                            Date()
                        ),
                        postID,
                        currentUser.userId
                    )

                }

                PostType.section_posts -> {
                    viewModel.addCommentsSection(
                        Comment(
                            "",
                            currentUser.userId,
                            comment,
                            currentUser.name,
                            currentUser.code,
                            Date()
                        ),
                        postID,
                        currentUser.section,
                        currentUser.department
                    )

                }

                PostType.general -> {
                    viewModel.addCommentsGeneral(
                        Comment(
                            "",
                            currentUser.userId,
                            comment,
                            currentUser.name,
                            currentUser.code,
                            Date()
                        ),
                        postID
                    )
                }

            }
            observeAddingComment()
        }

    }

    private fun observeAddingComment() {
        lifecycleScope.launchWhenCreated {
            viewModel.addCommentGeneral.collectLatest { state ->
                when (state) {
                    is Resource.Loading -> {
                        progress.visibility = View.VISIBLE

                    }

                    is Resource.Success -> {
                        progress.visibility = View.GONE
                        Toast.makeText(context, state.result, Toast.LENGTH_SHORT).show()
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

    private fun observeCommentGeneral() {
        lifecycleScope.launchWhenCreated {
            viewModel.getCommentGeneral.collectLatest { state ->
                when (state) {
                    is Resource.Loading -> {
                        progress.visibility = View.VISIBLE
                    }

                    is Resource.Success -> {
                        progress.visibility = View.GONE
                        commentList.clear()
                        state.result.forEach {
                            val comment = MyComments(
                                it.commentID,
                                it.description,
                                it.authorName,
                                it.authorCode,
                                false,
                                it.time
                            )
                            if (it.userID == currentUser.userId) {
                                comment.myComment = true
                            }
                            binding.NoCommentsYet.visibility = View.GONE
                            commentList.add(comment)
                        }
                        adapter.update(commentList)

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

}
