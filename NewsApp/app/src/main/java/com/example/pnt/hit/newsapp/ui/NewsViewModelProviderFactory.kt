package com.example.pnt.hit.newsapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pnt.hit.newsapp.repository.NewsRepository
import com.example.pnt.hit.newsapp.ui.viewmodel.NewsViewModel

class NewsViewModelProviderFactory(
    private val newsRepository: NewsRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsViewModel(newsRepository) as T
    }
}