package com.example.pnt.hit.mvvmsamplesimple

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pnt.hit.mvvmsamplesimple.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ItemOnClickListener {

    private val mainViewModel: MyViewModel by viewModels()

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val mainAdapter = MainAdapter(this, this@MainActivity)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupViewModel()
    }

    private fun setupViewModel() {
        mainViewModel.apply {
            setupData()
            mainData.observe(this@MainActivity) {
                setupRV(it)
            }
        }
    }

    private fun setupRV(it: MutableList<MainData>) {
        mainAdapter.setContent(it)
        binding.recyclerView.apply {
            adapter = mainAdapter
            layoutManager =
                GridLayoutManager(this@MainActivity, 2)
        }
    }

    override fun onClickListener(data: MainData) {
        Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show()
    }
}