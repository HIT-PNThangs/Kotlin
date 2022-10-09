package com.example.pnt.hit.retrofitguide.server

import com.example.pnt.hit.retrofitguide.Todo
import retrofit2.Response
import retrofit2.http.GET

interface TodoApi {
    @GET("/todos")
    suspend fun getTodos() : Response<List<Todo>>
}