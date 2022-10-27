package com.pnt.hit.roomdatabaseguide.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.pnt.hit.roomdatabaseguide.databinding.ItemLayoutBinding
import com.pnt.hit.roomdatabaseguide.fragment.ListFragmentDirections
import com.pnt.hit.roomdatabaseguide.model.User

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    private var userList = emptyList<User>()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(users: List<User>) {
        this.userList = users
        notifyDataSetChanged()
    }

    inner class UserViewHolder(private val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(user: User) {
            binding.tvId.text = "${user.id}"
            binding.tvFullname.text = "${user.firstName} ${user.lastName}"
            binding.tvAge.text = "${user.age}"

            binding.itemLayout.setOnClickListener {
                val action = ListFragmentDirections.actionListFragmentToUpdateFragment(user)
                binding.itemLayout.findNavController().navigate(action)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            ItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    override fun getItemCount() = userList.size
}