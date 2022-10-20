package com.example.pnt.hit.audiorecord.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.pnt.hit.audiorecord.adapter.Adapter
import com.example.pnt.hit.audiorecord.database.AppDatabase
import com.example.pnt.hit.audiorecord.databinding.ActivityGalleryBinding
import com.example.pnt.hit.audiorecord.model.AudioRecord
import com.example.pnt.hit.audiorecord.util.OnItemClickListener
import com.google.android.material.appbar.MaterialToolbar
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class GalleryActivity : AppCompatActivity(), OnItemClickListener {
    private lateinit var records: ArrayList<AudioRecord>
    private lateinit var mAdapter: Adapter
    private lateinit var db: AppDatabase

    private lateinit var binding: ActivityGalleryBinding

    private lateinit var toolbar: MaterialToolbar
    private lateinit var editBar: View

    private var allChecked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGalleryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun init() {
        records = ArrayList()
        mAdapter = Adapter(records, this)

        toolbar = binding.toolBar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        editBar = binding.editBar

        db = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "audioRecords"
        ).build()

        binding.recycleView.apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(context)
        }

        fetchAll()

        binding.searchInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val query = s.toString()

                searchDatabase(query)
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        binding.btClose.setOnClickListener {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setDisplayShowHomeEnabled(true)

            editBar.visibility = View.GONE
            records.map {
                it.isChecked = false
            }

            mAdapter.setEditMode(false)
        }

        binding.selectAll.setOnClickListener {
            allChecked = !allChecked
            records.map {
                it.isChecked = allChecked
            }

            mAdapter.notifyDataSetChanged()
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    @SuppressLint("NotifyDataSetChanged")
    private fun searchDatabase(s: String) {
        GlobalScope.launch {
            records.clear()

            records.addAll(db.audioRecordDao().searchDatabase("%$s%"))

            runOnUiThread {
                mAdapter.notifyDataSetChanged()
            }
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    @SuppressLint("NotifyDataSetChanged")
    private fun fetchAll() {
        GlobalScope.launch {
            records.clear()

            records.addAll(db.audioRecordDao().getAll())
            mAdapter.notifyDataSetChanged()
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onItemClickListener(position: Int) {
        val audioRecord = records[position]

        if(mAdapter.isEditMode()) {
            records[position].isChecked = !records[position].isChecked
            mAdapter.notifyDataSetChanged()
        } else {
            val intent = Intent(this, AudioPlayerActivity::class.java)

            intent.putExtra("filePath", audioRecord.filePath)
            intent.putExtra("fileName", audioRecord.fileName)

            startActivity(intent)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onItemLongClickListener(position: Int) {
        mAdapter.setEditMode(true)

        records[position].isChecked = !records[position].isChecked
        mAdapter.notifyDataSetChanged()

        if(mAdapter.isEditMode() && editBar.visibility == View.GONE) {
            supportActionBar?.setDisplayHomeAsUpEnabled(false)
            supportActionBar?.setDisplayShowHomeEnabled(false)

            editBar.visibility = View.VISIBLE
        }
    }
}