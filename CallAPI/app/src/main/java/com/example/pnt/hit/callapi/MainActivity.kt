package com.example.pnt.hit.callapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.pnt.hit.callapi.databinding.ActivityMainBinding
import com.example.pnt.hit.callapi.repository.Repository

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPost()
        viewModel.myResponse.observe(
            this,
            Observer {
                if(it.isSuccessful) {
                    Log.d("Response", it.body()?.userId.toString())
                    Log.d("Response", it.body()?.id.toString())
                    Log.d("Response", it.body()?.body!!)
                    binding.textView.text = it.body()?.body!!
                    Log.d("Response", it.body()?.title!!)
                } else {
                    Log.d("Response", it.errorBody().toString())
                    binding.textView.text = it.code().toString()
                }
            }
        )
    }
}