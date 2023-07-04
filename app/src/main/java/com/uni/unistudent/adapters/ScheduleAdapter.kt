package com.uni.unistudent.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.uni.unistudent.R
import com.uni.unistudent.classes.ScheduleDataType

var daySelected: String = "Saturday"

class ScheduleAdapter(
    val context: Context,
    var dataList: MutableList<ScheduleDataType>,
    val onItemClicked: (Int, ScheduleDataType) -> Unit,
    val onAttendClicked: (Int, ScheduleDataType) -> Unit

) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    companion object {
        const val VIEW_TYPE_ONE = 1
        const val VIEW_TYPE_TWO = 2
    }

    override fun getItemViewType(position: Int): Int {
        return if (dataList[position].type == VIEW_TYPE_ONE) VIEW_TYPE_ONE else VIEW_TYPE_TWO
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_ONE) {
            val view: View =
                LayoutInflater.from(context).inflate(R.layout.section_item, parent, false)
            ViewHolder1(view)
        } else {
            val view: View =
                LayoutInflater.from(context).inflate(R.layout.lecture_item, parent, false)
            ViewHolder2(view)
        }
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentItem = dataList[position]

        if (currentItem.type == VIEW_TYPE_TWO) {
            (holder as ViewHolder2)
            holder.course_name_lec.text = currentItem.courseName
            holder.location_lec.text = currentItem.hallID
            holder.lecturer.text = "Dr.${currentItem.professorName}"

            holder.amPm_lec.text = getTypeTime(currentItem.time)
            holder.from_lec.text = getTime12h(currentItem.time)
            holder.to_lec.text = getTime12h(currentItem.endTime)

            if (currentItem.hasRunning) {

                holder.attend_lec.alpha = 1f
                holder.isRunning_lec.text = context.getString(R.string.running)
                holder.isRunning_img.setImageResource(R.drawable.ic_running)
            } else {
                holder.attend_lec.alpha = .5f
                holder.isRunning_lec.text = context.getString(R.string.not_running)
                holder.isRunning_img.setImageResource(R.drawable.ic_not_running)
            }

        } else {
            (holder as ViewHolder1)
            holder.courseName.text = currentItem.courseName
            holder.location_sec.text = currentItem.hallID
            holder.assistant_sec.text = "eng.${currentItem.professorName}"

            holder.from_sec.text = getTime12h(currentItem.time)
            holder.to_sec.text = getTime12h(currentItem.endTime)
            holder.amPm_sec_sec.text = getTypeTime(currentItem.time)

            if (currentItem.hasRunning) {
                holder.attend_sec.alpha =1f
                holder.isRunning_sec.text = context.getString(R.string.running)
                holder.isRunning_img.setImageResource(R.drawable.ic_running)
            } else {
                holder.attend_sec.alpha =.5f
                holder.isRunning_sec.text = context.getString(R.string.not_running)
                holder.isRunning_img.setImageResource(R.drawable.ic_not_running)
            }

        }

    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun update(list: MutableList<ScheduleDataType>) {

        this.dataList = list
        notifyDataSetChanged()
    }

    inner class ViewHolder1(item: View) : RecyclerView.ViewHolder(item) {
        val isRunning_sec = item.findViewById<TextView>(R.id.sec_is_running)
        val isRunning_img = item.findViewById<ImageView>(R.id.lecture_is_running_img)
        val courseName = item.findViewById<TextView>(R.id.course_name_s)
        val location_sec = item.findViewById<TextView>(R.id.section_location)
        val assistant_sec = item.findViewById<TextView>(R.id.section_assistant)

        val from_sec = item.findViewById<TextView>(R.id.from_time_tv)
        val to_sec = item.findViewById<TextView>(R.id.to_time_tv)
        val amPm_sec_sec = item.findViewById<TextView>(R.id.time_AmPm_tv)

        val attend_sec = item.findViewById<CardView>(R.id.attend_card_section)
        val recyItem = item.findViewById<ConstraintLayout>(R.id.section_view)

        init {
            recyItem.setOnClickListener {
                onItemClicked.invoke(adapterPosition, dataList[adapterPosition])
            }
            attend_sec.setOnClickListener {
                onAttendClicked.invoke(adapterPosition, dataList[adapterPosition])
            }

        }


    }

    private inner class ViewHolder2(item: View) :
        RecyclerView.ViewHolder(item) {
        val isRunning_lec = item.findViewById<TextView>(R.id.lecture_is_running)
        val isRunning_img = item.findViewById<ImageView>(R.id.lecture_is_running_img)

        val course_name_lec = item.findViewById<TextView>(R.id.subject_name_tv)
        val location_lec = item.findViewById<TextView>(R.id.place_id_tv)
        val lecturer = item.findViewById<TextView>(R.id.prof_name_tv)
        val from_lec = item.findViewById<TextView>(R.id.from_time_tv)
        val to_lec = item.findViewById<TextView>(R.id.to_time_tv)
        val amPm_lec = item.findViewById<TextView>(R.id.time_AmPm_tv)
        val attend_lec = item.findViewById<CardView>(R.id.attend_card_lecture)
        val recyItem = item.findViewById<ConstraintLayout>(R.id.lecture_view)

        init {
            recyItem.setOnClickListener {
                onItemClicked.invoke(adapterPosition, dataList[adapterPosition])
            }
            attend_lec.setOnClickListener {
                onAttendClicked.invoke(adapterPosition, dataList[adapterPosition])
            }

        }
    }

    private fun getTypeTime(time: String): String {

        val mTime = time.split(":")[0].toInt()

        val isAmPm: String = if (mTime >= 12 && mTime != 24) {
            "PM"
        } else {
            "AM"
        }
        return isAmPm
    }

    private fun getTime12h(time: String): String {
        val mTime = time.split(":")
        val mHour = mTime[0].toInt()
        val mMinute = mTime[1].toInt()

        val modHour: Int = if (mHour > 12) {
            mHour - 12
        } else {
            mHour
        }
        val hour = if (modHour < 10) {
            "0$modHour"
        } else {
            modHour
        }


        val minute = if (mMinute < 10) {
            "0$mMinute"
        } else {
            mMinute
        }

        return "$hour:$minute"
    }

}


