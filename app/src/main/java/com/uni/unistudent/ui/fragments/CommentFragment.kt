package com.uni.unistudent.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.uni.unistudent.R
import com.uni.unistudent.adapters.CommentAdapter
import com.uni.unistudent.adapters.PostsAdapter
import com.uni.unistudent.classes.Comment
import com.uni.unistudent.classes.Courses
import com.uni.unistudent.classes.Posts
import com.uni.unistudent.classes.user.UserStudent
import com.uni.unistudent.data.Resource
import com.uni.unistudent.data.di.PostType
import com.uni.unistudent.databinding.FragmentCommentBinding
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

    private lateinit var aud: String

    private lateinit var adapter: CommentAdapter
    private lateinit var commentList: MutableList<Comment>

    private lateinit var binding: FragmentCommentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // update user data --------------------------------------------------------------------------------
        authViewModel.getSessionStudent { user ->
            if (user != null) {
                currentUser = user
                Toast.makeText(context, currentUser.name, Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(
                    context,
                    "error on loading user data please refresh the current screen ",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
        // update user data --------------------------------------------------------------------------------

        binding = FragmentCommentBinding.inflate(layoutInflater)

        val recyclerView = binding.commentRecycler
        progress = binding.progressBarComment
        commentList = arrayListOf()

        adapter = CommentAdapter(requireContext(), commentList)

        val args = this.arguments
        if (args != null) {

            postID = args.getString("postId", "")
            aud = args.getString("aud", "")
            courseID = args.getString("course", "")
        }

        when (aud) {
            PostType.course -> {
                viewModel.getCommentsCourse(postID, courseID)
                //observeCommentCourse()
            }

            PostType.personal_posts -> {
                viewModel.getCommentsPersonal(postID, currentUser.userId)
                //  observeCommentPersonal()
            }

            PostType.section_posts -> {
                viewModel.getCommentsSection(postID, currentUser.section, currentUser.department)
                //   observeCommentSection()
            }

            PostType.general -> {
                viewModel.getCommentsGeneral(postID)
                //   observeCommentGeneral()
            }

        }
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter


        observeCommentGeneral()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val send = view.findViewById<Button>(R.id.send_comment_bt)
        val commentText = view.findViewById<EditText>(R.id.comment_ed_text)
        var comment = ""
        send.setOnClickListener {
            comment = commentText.text.toString()
            when (aud) {
                PostType.course -> {
                    viewModel.addCommentsCourse(
                        Comment("", comment, currentUser.name, Date()),
                        postID,
                        courseID
                    )

                }

                PostType.personal_posts -> {
                    viewModel.addCommentsPersonal(
                        Comment("", comment, currentUser.name, Date()),
                        postID,
                        currentUser.userId
                    )

                }

                PostType.section_posts -> {
                    viewModel.addCommentsSection(
                        Comment("", comment, currentUser.name, Date()),
                        postID,
                        currentUser.section,
                        currentUser.department
                    )

                }

                PostType.general -> {
                    viewModel.addCommentsGeneral(
                        Comment("", comment, currentUser.name, Date()),
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
                            commentList.add(it)
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
    /*  private fun observeCommentCourse() {
           lifecycleScope.launchWhenCreated {
               viewModel.getCommentCourse.collectLatest {state->
                   when (state) {
                       is Resource.Loading -> {
                           progress.visibility=View.VISIBLE

                       }
                       is Resource.Success -> {

                           state.result.forEach {
                               commentList.add(it)
                           }

                       }
                       is Resource.Failure -> {
                           progress.visibility=View.INVISIBLE
                           Toast.makeText(context,state.exception.toString(),Toast.LENGTH_LONG).show()
                       }
                       else->{}
                   }
               }
           }

       }
       private fun observeCommentSection() {
           lifecycleScope.launchWhenCreated {
               viewModel.getCommentSection.collectLatest {state->
                   when (state) {
                       is Resource.Loading -> {
                           progress.visibility=View.VISIBLE

                       }
                       is Resource.Success -> {

                           state.result.forEach {
                               commentList.add(it)
                           }

                       }
                       is Resource.Failure -> {
                           progress.visibility=View.INVISIBLE
                           Toast.makeText(context,state.exception.toString(),Toast.LENGTH_LONG).show()
                       }
                       else->{}
                   }
               }
           }

       }


        private fun observeCommentPersonal() {
            lifecycleScope.launchWhenCreated {
                viewModel.getCommentPersonal.collectLatest { state ->
                    when (state) {
                        is Resource.Loading -> {
                            progress.visibility = View.VISIBLE

                        }
                        is Resource.Success -> {

                            state.result.forEach {
                                commentList.add(it)
                            }

                        }
                        is Resource.Failure -> {
                            progress.visibility = View.INVISIBLE
                            Toast.makeText(context, state.exception.toString(), Toast.LENGTH_LONG)
                                .show()
                        }
                        else -> {}
                    }
                }
            }

        }*/
}


