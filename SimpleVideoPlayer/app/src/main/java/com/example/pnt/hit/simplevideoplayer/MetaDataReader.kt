package com.example.pnt.hit.simplevideoplayer

import android.app.Application
import android.net.Uri
import android.provider.MediaStore

data class MetaData(
    val fileName: String
)

interface MetaDataReader {
    fun getDataFromUri(contentUri: Uri): MetaData?
}

class MetaDataReaderImpl(
    private val app: Application
) : MetaDataReader {
    override fun getDataFromUri(contentUri: Uri): MetaData? {
        if(contentUri.scheme != "content") {
            return null
        }

        val fileName = app.contentResolver.query(
            contentUri,
            arrayOf(MediaStore.Video.VideoColumns.DISPLAY_NAME),
            null,
            null,
            null
        )?.use { curror ->
            val index = curror.getColumnIndex(MediaStore.Video.VideoColumns.DISPLAY_NAME)
            curror.moveToFirst()
            curror.getString(index)
        }

        return fileName.let { fullName ->
            MetaData(
                fileName = Uri.parse(fileName).lastPathSegment ?: return null
            )
        }
    }
}