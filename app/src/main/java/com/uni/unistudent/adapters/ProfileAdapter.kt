package com.uni.unistudent.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.uni.unistudent.R
import com.uni.unistudent.BR


class ProfileAdapter<T>(private var items: List<T>) :
    RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder>() {
    val layoutId = R.layout.item_profile_course
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        return ProfileViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                layoutId,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        holder.binding.apply {
            val currentItem = items[position]
            setVariable(BR.course, currentItem)
        }
    }

    override fun getItemCount() = items.size


    class ProfileViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)

}