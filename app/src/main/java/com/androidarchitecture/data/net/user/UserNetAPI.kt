package com.androidarchitecture.data.net.user

import android.arch.lifecycle.LiveData
import com.androidarchitecture.entity.User

interface UserNetAPI {

    fun login(name: String, password: String): Boolean

    fun loadUserById(userId: Int): LiveData<User>
}