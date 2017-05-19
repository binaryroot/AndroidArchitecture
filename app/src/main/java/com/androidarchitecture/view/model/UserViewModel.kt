package com.androidarchitecture.view.model

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.androidarchitecture.data.UserDataSource
import com.androidarchitecture.entity.User

/**
 * Created by binary on 5/19/17.
 */
class UserViewModel : ViewModel() {

    lateinit var userDataSource: UserDataSource
    private var userData:LiveData<User>? = null

    fun getUserData(userId: Int) : LiveData<User>? {
        if (userData == null) {
            userData = userDataSource.loadUserInfoById(userId)
        }
        return userData
    }

}