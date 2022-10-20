package com.example.pnt.hit.audiorecord.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.pnt.hit.audiorecord.model.AudioRecord

@Dao
interface AudioRecordDao {
    @Query("SELECT * FROM audioRecords")
    suspend fun getAll() : List<AudioRecord>

    @Query("SELECT * FROM audioRecords WHERE fileName LIKE :query")
    suspend fun searchDatabase(query: String) : List<AudioRecord>

    @Insert
    suspend fun insert(vararg audioRecord: AudioRecord)

    @Delete
    suspend fun delete(audioRecord: AudioRecord)

    @Update
    suspend fun update(audioRecord: AudioRecord)
}