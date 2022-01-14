package com.one.testnotifications

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.one.testnotifications.databinding.UserItemBinding

@SuppressLint("NotifyDataSetChanged")
class UsersAdapter : RecyclerView.Adapter<UsersAdapter.UserViewHolder>() {

    var users = emptyList<User>()
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            UserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = users[position]
        with(holder.binding) {
            tvName.text = user.name
            tvCompany.text = user.company
            Glide.with(ivAvatar.context)
                .load(user.avatar)
                .error(R.drawable.ic_avatar_placeholder)
                .into(ivAvatar)
        }
    }

    override fun getItemCount() = users.size

    class UserViewHolder(val binding: UserItemBinding) : RecyclerView.ViewHolder(binding.root)
}