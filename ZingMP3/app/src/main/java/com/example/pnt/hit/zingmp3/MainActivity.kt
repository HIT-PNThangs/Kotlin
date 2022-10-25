package com.example.pnt.hit.zingmp3

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pnt.hit.zingmp3.databinding.ActivityMainBinding
import com.example.pnt.hit.zingmp3.model.Music
import com.example.pnt.hit.zingmp3.model.Song
import retrofit2.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var mAdapter: SongAdapter? = null
    private var listSong: MutableList<Song> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUp()

        val response = Api.api.getSong()

        response.enqueue(object : Callback<Music> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(call: Call<Music>, response: Response<Music>) {
                if(response.isSuccessful && response.body() != null) {
                    listSong.addAll(response.body()!!.data.song)
                    mAdapter = SongAdapter(listSong, this@MainActivity)
                    mAdapter!!.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<Music>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }


    private fun setUp() = binding.RecycleView.apply {
        adapter = mAdapter
        layoutManager = LinearLayoutManager(this@MainActivity)
    }
}
