package com.example.pnt.hit.newsapp.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pnt.hit.newsapp.R
import com.example.pnt.hit.newsapp.adapter.NewsAdapter
import com.example.pnt.hit.newsapp.database.ArticleDatabase
import com.example.pnt.hit.newsapp.repository.NewsRepository
import com.example.pnt.hit.newsapp.ui.NewsActivity
import com.example.pnt.hit.newsapp.ui.NewsViewModelProviderFactory
import com.example.pnt.hit.newsapp.ui.viewmodel.NewsViewModel
import com.example.pnt.hit.newsapp.util.Resource
import kotlinx.android.synthetic.main.fragment_breaking_news.*

class SearchNewsFragment : Fragment(R.layout.fragment_search_news) {
    lateinit var viewModel: NewsViewModel
    lateinit var newsAdapter: NewsAdapter

    private val TAG = "SearchNewsFragment"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val newsRepository = NewsRepository(ArticleDatabase(requireContext()))
        val viewModelProviderFactory = NewsViewModelProviderFactory(newsRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory)[NewsViewModel::class.java]

        setupRecyclerView()

        viewModel.searchNews.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is Resource.Success -> {
                    hideProgressBar()

                    response.data?.let { newsResponse ->
                        newsAdapter.differ.submitList(newsResponse.articles)
                    }
                }

                is Resource.Error -> {
                    hideProgressBar()

                    response.message?.let { message ->
                        Log.e(TAG, "An error: $message")
                    }
                }

                is Resource.Loading -> {
                    showProgressBar()
                }
            }
        })
    }

    private fun setupRecyclerView() {
        newsAdapter = NewsAdapter()

        rvBreakingNews.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    private fun hideProgressBar() {
        paginationProgressBar.visibility = View.GONE
    }

    private fun showProgressBar() {
        paginationProgressBar.visibility = View.VISIBLE
    }
}