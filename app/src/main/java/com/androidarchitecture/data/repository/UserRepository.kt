package com.androidarchitecture.data.repository

import android.arch.lifecycle.LiveData
import com.androidarchitecture.data.UserDataSource
import com.androidarchitecture.data.net.user.UserNetAPI
import com.androidarchitecture.entity.User
import com.androidarchitecture.utility.L
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by binary on 5/18/17.
 */
@Singleton
class UserRepository @Inject constructor(userRepositoryFactory: UserRepositoryFactory) : UserDataSource {

    private val userNetApi = userRepositoryFactory.createUserNetApi()
    private val userLocalApi = userRepositoryFactory.createUserLocalAPI()

    override fun loadUserInfoById(userId: Int): LiveData<User> {
        userLocalApi.findById(userId).let {
            if (it.value == null) {
                return userNetApi.loadUserById(userId)
            } else {
                return it
            }
        }
    }
}