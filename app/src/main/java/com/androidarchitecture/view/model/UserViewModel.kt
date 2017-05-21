package com.androidarchitecture.view.model

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.androidarchitecture.data.UserDataSource
import com.androidarchitecture.entity.User
import android.arch.lifecycle.MutableLiveData



/**
 * Created by binary on 5/19/17.
 */
class UserViewModel : ViewModel() {

    lateinit var userDataSource: UserDataSource
    private var users: MutableLiveData<User>? = null

    //region UserViewModel
    fun getUser(userId: Int): LiveData<User>? {
        if (users == null) {
            users = MutableLiveData()
            loadUser(userId)
        }
        return users
    }
    //endregion

    //region UtilityAPI
    private fun loadUser(userId: Int) {
        userDataSource.loadUserInfoById(userId).observeForever {
            users?.postValue(it)
            it?.let { userDataSource.saveUser(it) }
        }
    }
    //endregion
}