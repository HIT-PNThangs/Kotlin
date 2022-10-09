package com.example.pnt.hit.retrofitguide

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pnt.hit.retrofitguide.databinding.ActivityMainBinding
import com.example.pnt.hit.retrofitguide.server.RetrofitInstance
import retrofit2.HttpException
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var todoAdapter: TodoAdapter

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()

        lifecycleScope.launchWhenCreated {
            binding.progressBar.isVisible = true
            val response = try {
                RetrofitInstance.api.getTodos()
            } catch (e: IOException) {
                Log.e(TAG, "IOException, you might not have interest connection")
                binding.progressBar.isVisible = false
                return@launchWhenCreated
            } catch (e: HttpException) {
                Log.e(TAG, "HttpException, unexpected response")
                binding.progressBar.isVisible = false
                return@launchWhenCreated
            }

            if(response.isSuccessful && response.body() != null) {
                todoAdapter.todos = response.body()!!
            } else {
                Log.e(TAG, "Response not successful")
                binding.progressBar.isVisible = false
                return@launchWhenCreated
            }

            binding.progressBar.isVisible = false
        }
    }

    private fun setupRecyclerView() = binding.rvTodos.apply {
        todoAdapter = TodoAdapter()
        adapter = todoAdapter
        layoutManager = LinearLayoutManager(this@MainActivity)
    }
}