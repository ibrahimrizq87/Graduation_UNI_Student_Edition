package com.uni.unistudent.adapters


import android.content.Context
import android.os.Build
import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.uni.unistudent.R
import com.uni.unistudent.classes.Posts
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import java.util.Date

class PostsAdapter(
    val context: Context,
    var postList: MutableList<Posts>,
    val onItemClicked: (Int, Posts) -> Unit,
    val onComment: (Int, Posts) -> Unit


) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    companion object {
        const val WITH_IMAGE = 1
        const val WITHOUT_IMAGE = 2
    }

    override fun getItemViewType(position: Int): Int {
        return if (postList[position].type == WITH_IMAGE) WITH_IMAGE else WITHOUT_IMAGE
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == WITH_IMAGE) {
            val view: View =
                LayoutInflater.from(context).inflate(R.layout.post_item_with_image, parent, false)
            ViewHolder1(view)
        } else {
            val view: View = LayoutInflater.from(context)
                .inflate(R.layout.post_item_without_image, parent, false)
            ViewHolder2(view)
        }
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentItem = postList[position]

        if (currentItem.type == WITHOUT_IMAGE) {
            (holder as ViewHolder2)
            holder.auth.text = currentItem.authorName
            holder.post_time.text = formatDate(currentItem.time)
            holder.audience.text = currentItem.audience
            holder.text.text =currentItem.description

        } else {
            (holder as ViewHolder1)
            Glide.with(context)
                .load(currentItem.imageUrl)
                .into(holder.image)
            holder.auth.text = currentItem.authorName
            holder.post_time.text = formatDate(currentItem.time)
            holder.audience.text = currentItem.audience
            holder.text.text = currentItem.description

        }

    }


    override fun getItemCount(): Int {
        return postList.size
    }

    fun update(list: MutableList<Posts>) {
        this.postList = list
        notifyDataSetChanged()
    }

    inner class ViewHolder1(item: View) : RecyclerView.ViewHolder(item) {
        val image = item.findViewById<ImageView>(R.id.post_image)
        val auth = item.findViewById<TextView>(R.id.auth_with)
        val post_time: TextView = item.findViewById(R.id.post_time_text_with)
        val audience = item.findViewById<TextView>(R.id.audience_with)
        val text = item.findViewById<TextView>(R.id.text_with)

        val itemComments: LinearLayout = item.findViewById(R.id.comment_layout)
        val recyItem = item.findViewById<ConstraintLayout>(R.id.post_item_with)

        init {
            recyItem.setOnClickListener {
                onItemClicked.invoke(adapterPosition, postList[adapterPosition])
            }
            itemComments.setOnClickListener {
                onComment.invoke(adapterPosition, postList[adapterPosition])
            }

        }


    }

    private inner class ViewHolder2(item: View) :
        RecyclerView.ViewHolder(item) {
        val auth: TextView = item.findViewById(R.id.auth_without)
        val post_time: TextView = item.findViewById(R.id.post_time_text_without)
        val audience: TextView = item.findViewById(R.id.audience_without)
        val text: TextView = item.findViewById(R.id.text_without)

        val postItem: ConstraintLayout = item.findViewById(R.id.post_item_without)
        val itemComments: LinearLayout = item.findViewById(R.id.comment_layout)

        init {
            itemComments.setOnClickListener {
                onComment.invoke(adapterPosition, postList[adapterPosition])
            }

            postItem.setOnClickListener {
                onItemClicked.invoke(adapterPosition, postList[adapterPosition])
            }

        }

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

}