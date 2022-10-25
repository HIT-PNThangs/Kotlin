package com.example.pnt.hit.callapi.repository

import com.example.pnt.hit.callapi.api.RetrofitInstance
import com.example.pnt.hit.callapi.model.Post
import retrofit2.Response

class Repository {
    suspend fun getPost(): Response<Post> {
        return RetrofitInstance.api.getPost()
    }
}