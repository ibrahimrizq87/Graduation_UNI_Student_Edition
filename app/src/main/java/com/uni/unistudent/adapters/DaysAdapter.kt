package com.uni.unistudent.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.uni.unistudent.R

class DaysAdapter(private val customClickListener: CustomClickListener,private val context: android.content.Context) :
    RecyclerView.Adapter<ViewHolder>() {

    interface CustomClickListener {
        fun onCustomClick(day: String)
    }

    private var days = mutableListOf<String>(
        "Sat",
        "Sun",
        "Mon",
        "Tuesday",
        "Wed",
        "Thu",
        "Fri",
    )
    private var oldDaySelected: CardView? = null
    private var oldDaySelectedTV: TextView? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_days_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.day.text = days[position]
        if (position==0){
            holder.layout.setCardBackgroundColor( ContextCompat.getColor(context,R.color.green))
            holder.day.setTextColor( ContextCompat.getColor(context,R.color.white_100))
            oldDaySelected =holder.layout
            oldDaySelectedTV=holder.day
            customClickListener.onCustomClick(days[0])
        }

        holder.layout.setOnClickListener {
            oldDaySelected?.setCardBackgroundColor(ContextCompat.getColor(context,R.color.white_100))
            oldDaySelectedTV?.setTextColor(ContextCompat.getColor(context,R.color.black_50))

            holder.layout.setCardBackgroundColor( ContextCompat.getColor(context,R.color.green))
            holder.day.setTextColor( ContextCompat.getColor(context,R.color.white_100))
            customClickListener.onCustomClick(days[position])
            oldDaySelected =holder.layout
            oldDaySelectedTV=holder.day
        }
    }

    override fun getItemCount(): Int {
        return days.size
    }


}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val day: TextView = view.findViewById(R.id.day_tv)
    val layout: CardView = view.findViewById(R.id.cardView_day)
}



