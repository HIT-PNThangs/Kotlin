package com.example.pnt.hit.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pnt.hit.recyclerview.databinding.ItemTodoBinding

class TodoAdapter(
    var list: List<Todo>
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder> () {
    inner class TodoViewHolder(val binding: ItemTodoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(ItemTodoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.binding.apply {
            tvTitle.text = list[position].title
            checkBox.isChecked = list[position].isSelected
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}