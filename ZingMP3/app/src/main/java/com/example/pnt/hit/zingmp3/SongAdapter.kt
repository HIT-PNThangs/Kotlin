package com.example.pnt.hit.zingmp3

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pnt.hit.zingmp3.databinding.ItemViewBinding
import com.example.pnt.hit.zingmp3.model.Music
import com.example.pnt.hit.zingmp3.model.Song

class SongAdapter(
    val listSong: List<Song>,
    val context: Context
) : RecyclerView.Adapter<SongAdapter.ItemViewHolder>() {
    inner class ItemViewHolder(val binding: ItemViewBinding): RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bindData(song: Song) {
            when (adapterPosition) {
                0 -> binding.tvRank.setTextColor(Color.parseColor("#FF6666"))
                1 -> binding.tvRank.setTextColor(Color.parseColor("#33FF00"))
                2 -> binding.tvRank.setTextColor(Color.parseColor("#FF9900"))
                else -> binding.tvRank.setTextColor(Color.parseColor("#FFFFFF"))
            }

            binding.tvRank.text = "${adapterPosition + 1}"
            binding.tvName.text = song.name
            binding.tvArtists.text = song.artists_names
            Glide.with(context).load(song.thumbnail).into(binding.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(ItemViewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bindData(listSong[position])
    }

    override fun getItemCount() = listSong.size
}