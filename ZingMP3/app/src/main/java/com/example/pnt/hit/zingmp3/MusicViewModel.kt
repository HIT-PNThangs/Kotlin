package com.example.pnt.hit.zingmp3

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pnt.hit.zingmp3.model.Song

class MusicViewModel: ViewModel() {
    var mSongTopLiveData: MutableLiveData<MutableList<Song>> = MutableLiveData()

    fun getTopSongFromAPI() {
        Repository.getInstance().getTopMusic { isSuccess, response ->
            if (isSuccess) {
                mSongTopLiveData.postValue(response?.data?.song as MutableList<Song>?)
            }
        }
    }
}