package com.example.pnt.hit.mvvmsamplesimple

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pnt.hit.mvvmsamplesimple.databinding.ItemLayoutBinding
import com.squareup.picasso.Picasso

class MainAdapter(
    private val listener: ItemOnClickListener,
    private val context: Context
) : RecyclerView.Adapter<MainAdapter.ItemViewHolder>() {
    inner class ItemViewHolder(val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindItem(data: MainData, listener: ItemOnClickListener) {

            val image =
                "https://i.pinimg.com/originals/2f/c4/c4/2fc4c47717344e211c1c54835bb02dd1.jpg"

            binding.textViewTitle.text = data.name
            binding.textViewSubtitle.text = data.age.toString()
            Picasso.get().load(image).into(binding.imageView)
            itemView.setOnClickListener { listener.onClickListener(data) }
        }
    }

    private val listData = mutableListOf<MainData>()

    fun setContent(data: List<MainData>) {
        listData.clear()
        listData.addAll(data)
    }

    fun notifyInserted(data: MainData, position: Int) {
        listData.add(position, data)
        notifyItemInserted(position)
    }

    fun clearData() {
        listData.clear()
        notifyItemRangeRemoved(0, listData.size - 1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            ItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bindItem(listData[position], listener)
    }

    override fun getItemCount() = listData.size
}