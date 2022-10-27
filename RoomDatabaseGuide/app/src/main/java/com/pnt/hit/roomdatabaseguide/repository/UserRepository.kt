package com.pnt.hit.roomdatabaseguide.repository

import androidx.lifecycle.LiveData
import com.pnt.hit.roomdatabaseguide.dao.UserDao
import com.pnt.hit.roomdatabaseguide.model.User

class UserRepository(
    private val userDao: UserDao
) {
    val list: LiveData<List<User>> = userDao.getUsers()

    fun addUser(user: User) {
        userDao.insertUser(user)
    }

    fun updateUser(user: User) {
        userDao.updateUser(user)
    }

    fun deleteUser(user: User) {
        userDao.deleteUser(user)
    }

    fun deleteAllUser() {
        userDao.deleteAllUser()
    }
}