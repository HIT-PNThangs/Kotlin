package com.example.pnt.hit.retrofitguide

data class Todo(
    val completed: Boolean,
    val id: Int,
    val userId: String,
    val title: String
)
