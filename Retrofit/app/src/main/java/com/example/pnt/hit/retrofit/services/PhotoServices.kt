package com.example.pnt.hit.retrofit.services

import com.example.pnt.hit.retrofit.model.Photo
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface PhotoServices {
    companion object {
        private const val BASE_URL = "https://jsonplaceholder.typicode.com"

        fun create(): PhotoServices {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(PhotoServices::class.java)
        }
    }

    @GET("/photos")
    suspend fun getPhotos(): List<Photo>
}