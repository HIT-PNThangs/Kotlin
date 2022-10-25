package com.example.pnt.hit.callapi.api

import com.example.pnt.hit.callapi.model.Post
import retrofit2.Response
import retrofit2.http.GET

interface Api {
    @GET("posts/1")
    suspend fun getPost(): Response<Post>
}