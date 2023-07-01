package com.uni.unistudent.adapters

import android.content.Context
import android.os.Build
import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.uni.unistudent.R
import com.uni.unistudent.classes.Comment
import com.uni.unistudent.classes.MyComments
import com.uni.unistudent.classes.Posts
import java.time.Duration
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import java.util.Date


class CommentAdapter(
    val context: Context,
    var commentList: MutableList<MyComments>,
    val onUpdate: (Int, MyComments) -> Unit,
    val onDelete: (Int, MyComments) -> Unit

) : RecyclerView.Adapter<CommentAdapter.myViewHolder>() {
    lateinit var instance: View
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.comment_item, parent, false)


        return myViewHolder(view)
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {

        val currentItem = commentList[position]
        if (currentItem.myComment) {
            holder.delete_bt.visibility = View.VISIBLE
            holder.update_bt.visibility = View.VISIBLE
        }
        holder.auth.text = currentItem.authorName
        holder.auth_id.text = currentItem.authorCode

        holder.comment.text = currentItem.description
        holder.time.text = formatDate(currentItem.time)

    }

    private fun formatDate(date: Date): String {
        val currentTimeMillis = System.currentTimeMillis()
        val inputTimeMillis = date.time
        val timeDifference = currentTimeMillis - inputTimeMillis

        return when {
            timeDifference < DateUtils.MINUTE_IN_MILLIS -> "just now"
            timeDifference < DateUtils.HOUR_IN_MILLIS -> {
                val minutes = (timeDifference / DateUtils.MINUTE_IN_MILLIS).toInt()
                "${minutes}m"
            }

            timeDifference < DateUtils.DAY_IN_MILLIS -> {
                val hours = (timeDifference / DateUtils.HOUR_IN_MILLIS).toInt()
                "${hours}h "
            }

            timeDifference < 31 * DateUtils.DAY_IN_MILLIS -> {
                val days = (timeDifference / DateUtils.DAY_IN_MILLIS).toInt()
                "${days} day "
            }

            else -> {
                val months = (timeDifference / (31 * DateUtils.DAY_IN_MILLIS)).toInt()
                "${months} month "
            }
        }
    }

    fun update(list: MutableList<MyComments>) {
        this.commentList = list
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int {

        return commentList.size
    }


    inner class myViewHolder(item: View) : RecyclerView.ViewHolder(item) {


        val auth = item.findViewById<TextView>(R.id.author_comment)
        val auth_id = item.findViewById<TextView>(R.id.author_id)
        val comment = item.findViewById<TextView>(R.id.comment_text)
        val time = item.findViewById<TextView>(R.id.time_text)
        val update_bt: ImageButton = item.findViewById(R.id.update_comment)
        val delete_bt: ImageButton = item.findViewById(R.id.delete_comment)


        init {

            update_bt.setOnClickListener {
                onUpdate.invoke(adapterPosition, commentList[adapterPosition])
            }
            delete_bt.setOnClickListener {
                onDelete.invoke(adapterPosition, commentList[adapterPosition])
            }

        }


    }


}