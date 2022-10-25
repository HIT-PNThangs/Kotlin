package com.example.pnt.hit.retrofit.repository

import com.example.pnt.hit.retrofit.model.Photo
import com.example.pnt.hit.retrofit.services.PhotoServices
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class PhotoRepository {
    private val apiClient by lazy {
        PhotoServices.create()
    }

    suspend fun getPhotos(): Flow<List<Photo>> {
        return flow {
            emit(apiClient.getPhotos())
        }.flowOn(Dispatchers.IO)
    }
}