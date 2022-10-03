package com.example.pnt.hit.newsapp.model

data class NewsResponse(
    val articles: List<Article>,
    val state: String,
    val totalResults: Int
)
