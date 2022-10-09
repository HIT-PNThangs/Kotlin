package com.example.pnt.hit.newsapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.pnt.hit.newsapp.R
import com.example.pnt.hit.newsapp.database.ArticleDatabase
import com.example.pnt.hit.newsapp.repository.NewsRepository
import com.example.pnt.hit.newsapp.ui.viewmodel.NewsViewModel

class NewsActivity : AppCompatActivity() {
    lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        val newsRepository = NewsRepository(ArticleDatabase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(newsRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory)[NewsViewModel::class.java]

//        bottomNavigationView.setupWithNavController(newsNavHostFragment.findNavController())
    }
}