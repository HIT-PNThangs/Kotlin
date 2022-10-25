package com.example.pnt.hit.zingmp3.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Artist(
    val link: String,
    val name: String
) : Parcelable