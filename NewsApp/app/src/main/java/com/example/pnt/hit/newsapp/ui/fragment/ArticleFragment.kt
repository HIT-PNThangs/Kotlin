package com.example.pnt.hit.newsapp.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.pnt.hit.newsapp.R
import com.example.pnt.hit.newsapp.database.ArticleDatabase
import com.example.pnt.hit.newsapp.repository.NewsRepository
import com.example.pnt.hit.newsapp.ui.NewsViewModelProviderFactory
import com.example.pnt.hit.newsapp.ui.viewmodel.NewsViewModel

class ArticleFragment : Fragment(R.layout.fragment_article) {
    lateinit var viewModel: NewsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val newsRepository = NewsRepository(ArticleDatabase(requireContext()))
        val viewModelProviderFactory = NewsViewModelProviderFactory(newsRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory)[NewsViewModel::class.java]
    }
}