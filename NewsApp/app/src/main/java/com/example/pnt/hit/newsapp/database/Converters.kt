package com.example.pnt.hit.newsapp.database

import androidx.room.TypeConverter
import com.example.pnt.hit.newsapp.model.Source

class Converters {
    @TypeConverter
    fun fromSource(source: Source): String {
        return source.name
    }

    @TypeConverter
    fun toSource(name: String): Source {
        return Source(name, name)
    }
}