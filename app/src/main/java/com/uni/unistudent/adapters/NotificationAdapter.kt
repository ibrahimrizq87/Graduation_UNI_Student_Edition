package com.uni.unistudent.adapters

import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.uni.unistudent.BR
import com.uni.unistudent.R
import com.uni.unistudent.classes.Posts
import java.util.Date

@Suppress("UNREACHABLE_CODE")
class NotificationAdapter(private var items: List<Posts>):
    RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder>() {

    private var notificationCount = 0
    private val layoutId = R.layout.item_notification

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        val binding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context),
            layoutId,
            parent,
            false
        )
        return NotificationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun updateData(newItems: List<Posts>) {
        items = newItems
        notificationCount = newItems.size
        notifyDataSetChanged()
    }

    fun getNotificationCount(): Int {
        return notificationCount
    }

    class NotificationViewHolder(private val binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Posts) {
            binding.apply {
                setVariable(BR.post, item)

                // Format the date string using formatDate function
                val formattedDate = formatDate(item.time)
                setVariable(BR.formattedDate, formattedDate)

                executePendingBindings()
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
        class NotificationViewHolder(val binding: ViewDataBinding) :
            RecyclerView.ViewHolder(binding.root)
    }
}