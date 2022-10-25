package com.example.pnt.hit.zingmp3

import com.example.pnt.hit.zingmp3.model.Music
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface Api {
    companion object {
        val api = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://mp3.zing.vn/")
            .build()
            .create(Api::class.java)
    }

    @GET("xhr/chart-realtime")
    fun getSong(): List<Music>
}