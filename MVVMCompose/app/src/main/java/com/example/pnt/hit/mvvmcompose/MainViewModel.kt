package com.example.pnt.hit.mvvmcompose

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _counter = mutableStateOf(0)

    val counter: State<Int> = _counter

    fun onAdd() {
        _counter.value = _counter.value + 1
    }
}