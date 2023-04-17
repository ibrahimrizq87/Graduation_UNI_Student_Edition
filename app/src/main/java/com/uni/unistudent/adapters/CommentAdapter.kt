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
import com.uni.unistudent.classes.Comment


class CommentAdapter(
    val context: Context,
    var commentList:MutableList<Comment>,

)
    : RecyclerView.Adapter<CommentAdapter.myViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val view : View = LayoutInflater.from(context).inflate(R.layout.comment_item,parent,false)
        return myViewHolder(view)
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        val currentItem = commentList[position]
        holder.auth.text = currentItem.authorName
        holder.comment.text = currentItem.description


    }
    fun update(list: MutableList<Comment>){
        this.commentList=list
        notifyDataSetChanged()
    }




    override fun getItemCount(): Int {
        return commentList.size
    }


    inner    class myViewHolder(item: View) : RecyclerView.ViewHolder(item){

        val auth = item.findViewById<TextView>(R.id.author_comment)
        val comment = item.findViewById<TextView>(R.id.comment_text)




    }

}