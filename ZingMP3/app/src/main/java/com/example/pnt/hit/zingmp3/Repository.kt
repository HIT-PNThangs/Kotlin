package com.example.pnt.hit.zingmp3

import com.example.pnt.hit.zingmp3.model.Music
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {
    companion object {
        private var INSTANCE: Repository? = null

        fun getInstance() = INSTANCE?: Repository().also {
            INSTANCE = it
        }
    }

    fun getTopMusic(result: (isSuccess: Boolean, respone: Music?) -> Unit) {
        Api.api.getSong().enqueue(object : Callback<Music> {
            override fun onResponse(call: Call<Music>, response: Response<Music>) {
                if (response.isSuccessful && response != null) {
                    //call API Chart Realtime
                    result(true, response.body())
                } else {
                    result(false, null)
                }
            }

            override fun onFailure(call: Call<Music>, t: Throwable) {

            }
        })
    }
}