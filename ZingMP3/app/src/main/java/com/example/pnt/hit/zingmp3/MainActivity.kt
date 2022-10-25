package com.example.pnt.hit.zingmp3

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pnt.hit.zingmp3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MusicViewModel

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MusicViewModel::class.java]
        viewModel.getTopSongFromAPI()

        viewModel.mSongTopLiveData.observe(this) {
            val mAdapter = SongAdapter(it, this@MainActivity)
            binding.RecycleView.apply {
                adapter = mAdapter

                layoutManager = LinearLayoutManager(
                    this@MainActivity,
                    LinearLayoutManager.VERTICAL,
                    false
                )

                addItemDecoration(
                    DividerItemDecoration(
                        baseContext,
                        DividerItemDecoration.VERTICAL
                    )
                )
            }
        }
    }
}
