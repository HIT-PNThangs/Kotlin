package com.pnt.hit.roomdatabaseguide.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.pnt.hit.roomdatabaseguide.model.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User)

    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun getUsers(): LiveData<List<User>>

    @Update
    fun updateUser(user: User)

    @Query("DELETE FROM user_table")
    fun deleteAllUser()

    @Insert
    fun deleteUser(user: User)
}