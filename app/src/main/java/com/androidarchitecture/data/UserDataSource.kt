package com.androidarchitecture.data

import android.arch.lifecycle.LiveData;
import com.androidarchitecture.entity.User

interface UserDataSource {

    fun loadUserInfoById(userId : Int) : LiveData<User>

    fun saveUser(user: User)
}