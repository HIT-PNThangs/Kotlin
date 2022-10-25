package com.example.pnt.hit.retrofit.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pnt.hit.retrofit.adapter.PhotoAdapter
import com.example.pnt.hit.retrofit.databinding.ActivityMainBinding
import com.example.pnt.hit.retrofit.model.Photo
import com.example.pnt.hit.retrofit.viewmodel.PhotoViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpRecyclerView()
    }

    private val viewModel by lazy {
        ViewModelProvider(this)[PhotoViewModel::class.java]
    }

    private fun setUpRecyclerView() {
        viewModel.getPhotos {}
        val data: MutableList<Photo> = ArrayList()
        viewModel.progressStatus.observe(this) {
            if (!it) {
                binding.progressPhoto.visibility = View.VISIBLE
            } else {
                binding.progressPhoto.visibility = View.INVISIBLE
            }
        }
        viewModel.photoList.observe(this) { it ->
            data.addAll(it)

            val photoAdapter = PhotoAdapter(data)
            binding.rcvPhoto.apply {
                layoutManager = LinearLayoutManager(
                    this@MainActivity,
                    LinearLayoutManager.VERTICAL,
                    false
                )

                adapter = photoAdapter

                addItemDecoration(
                    DividerItemDecoration(
                        baseContext,
                        DividerItemDecoration.VERTICAL
                    )
                )
            }

            photoAdapter.setOnClickItem {
                val intent = Intent(baseContext, DetailActivity::class.java)
                intent.putExtra("photo", data[it])
                startActivity(intent)
            }
        }
    }
}