package com.example.pnt.hit.mvvmsamplesimple

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class MyViewModel @Inject constructor() : ViewModel() {

    private val data = mutableListOf<MainData>()

    private var _mainData = MutableLiveData<MutableList<MainData>>()
    var mainData: LiveData<MutableList<MainData>> = _mainData

    fun setupData() {
        data.add(MainData("PNT", 24))
        data.add(MainData("PNT", 24))
        data.add(MainData("PNT", 24))
        data.add(MainData("PNT", 24))
        data.add(MainData("PNT", 24))
        data.add(MainData("PNT", 24))
        data.add(MainData("PNT", 24))
        data.add(MainData("PNT", 24))
        data.add(MainData("PNT", 24))
        data.add(MainData("PNT", 24))

        _mainData.postValue(data)
    }
}