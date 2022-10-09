package com.example.pnt.hit.newsapp.repository

import com.example.pnt.hit.newsapp.api.RetrofitInstance
import com.example.pnt.hit.newsapp.database.ArticleDatabase

class NewsRepository(
    val db: ArticleDatabase
) {
    suspend fun getBreakingNews(
        countryCode: String,
        pageNumber: Int
    ) = RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    suspend fun searchNews(
        searchQuery: String,
        pageNumber: Int
    ) = RetrofitInstance.api.searchForNews(searchQuery, pageNumber)
}