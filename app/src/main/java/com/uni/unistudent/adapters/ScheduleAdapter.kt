package com.uni.unistudent.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.uni.unistudent.R
import com.uni.unistudent.classes.ScheduleDataType

class ScheduleAdapter(
    val context: Context,
    var dataList:MutableList<ScheduleDataType>,
    val onItemClicked:(Int,ScheduleDataType) ->Unit,
    val onAttendClicked:(Int,ScheduleDataType) ->Unit

)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    companion object {
        const val VIEW_TYPE_ONE = 1
        const val VIEW_TYPE_TWO = 2
    }






    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == VIEW_TYPE_ONE) {
        val view : View = LayoutInflater.from(context).inflate(R.layout.section_item,parent,false)
        return ViewHolder1(view)
        }
        val view : View = LayoutInflater.from(context).inflate(R.layout.lecture_item,parent,false)
        return ViewHolder2(view)
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentItem = dataList[position]

if (currentItem.type == VIEW_TYPE_TWO){
    (holder as ViewHolder2)
    holder.courseName_l.text = currentItem.courseName
    holder.location_l.text = currentItem.hallID
    holder.lecturer.text = currentItem.professorName
    holder.day_l.text = currentItem.day
    holder.from_l.text = currentItem.time
    holder.to_l.text = currentItem.endTime

}else{
    (holder as ViewHolder1)
    holder.courseName.text = currentItem.courseName
    holder.location.text = currentItem.hallID
    holder.assistant.text = currentItem.professorName
    holder.day.text = currentItem.day
    holder.from.text = currentItem.time
    holder.to.text = currentItem.endTime
}

    }



    override fun getItemCount(): Int {
        return dataList.size
    }
    fun update(list: MutableList<ScheduleDataType>){
        this.dataList=list
        notifyDataSetChanged()
    }
    inner class ViewHolder1(item: View) : RecyclerView.ViewHolder(item){

        val courseName = item.findViewById<TextView>(R.id.course_name_s)
        val location = item.findViewById<TextView>(R.id.section_location)
        val assistant = item.findViewById<TextView>(R.id.section_assistant)
        val day = item.findViewById<TextView>(R.id.section_day)
        val from = item.findViewById<TextView>(R.id.section_start_time)
        val to = item.findViewById<TextView>(R.id.section_end_time)
        val attend = item.findViewById<Button>(R.id.attend_bt_section)

        val recyItem = item.findViewById<ConstraintLayout>(R.id.section_view)
        init {
            recyItem.setOnClickListener {
                onItemClicked.invoke(adapterPosition,dataList[adapterPosition])
            }
            attend.setOnClickListener {
                onAttendClicked.invoke(adapterPosition,dataList[adapterPosition])
            }

        }


    }
    private inner class ViewHolder2(item: View) :
        RecyclerView.ViewHolder(item) {

        val courseName_l = item.findViewById<TextView>(R.id.course_name_l)
        val location_l = item.findViewById<TextView>(R.id.lecture_location)
        val lecturer = item.findViewById<TextView>(R.id.lecture_lecturer)
        val day_l = item.findViewById<TextView>(R.id.lecture_day)
        val from_l = item.findViewById<TextView>(R.id.lecture_start_time)
        val to_l = item.findViewById<TextView>(R.id.lecture_end_time)
        val attend_l = item.findViewById<Button>(R.id.attend_bt_lecture)

        val recyItem = item.findViewById<ConstraintLayout>(R.id.lecture_view)
        init {
            recyItem.setOnClickListener {
                onItemClicked.invoke(adapterPosition,dataList[adapterPosition])
            }
            attend_l.setOnClickListener {
                onAttendClicked.invoke(adapterPosition,dataList[adapterPosition])
            }

        }
    }

}


