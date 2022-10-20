package com.example.pnt.hit.audiorecord.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pnt.hit.audiorecord.databinding.ItemviewLayoutBinding
import com.example.pnt.hit.audiorecord.model.AudioRecord
import com.example.pnt.hit.audiorecord.util.OnItemClickListener
import java.text.SimpleDateFormat
import java.util.*

class Adapter(
    var records: ArrayList<AudioRecord>,
    var listener: OnItemClickListener
) : RecyclerView.Adapter<Adapter.ViewHolder>() {
    private var editMode = false

    fun isEditMode() : Boolean {
        return editMode
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setEditMode(mode: Boolean) {
        if(editMode != mode) {
            editMode = mode
            notifyDataSetChanged()
        }
    }

    inner class ViewHolder(val binding: ItemviewLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemviewLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    @SuppressLint("SimpleDateFormat", "SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (position != RecyclerView.NO_POSITION) {
            val record = records[position]

            val format = SimpleDateFormat("dd/MM/yyyy")
            val date = Date(record.timestamp)
            val strDate = format.format(date)

            holder.binding.tvFilename.text = record.fileName
            holder.binding.tvMeta.text = "${record.duration} $strDate"

            holder.binding.itemAudioRecord.setOnClickListener {
                listener.onItemClickListener(position)
            }

            holder.binding.itemAudioRecord.setOnLongClickListener {
                listener.onItemLongClickListener(position)
                true
            }

            if(editMode) {
                holder.binding.checkBox.visibility = View.VISIBLE
                holder.binding.checkBox.isChecked = record.isChecked
            } else {
                holder.binding.checkBox.visibility = View.INVISIBLE
                holder.binding.checkBox.isChecked = false
            }
        }
    }

    override fun getItemCount(): Int {
        return records.size
    }
}