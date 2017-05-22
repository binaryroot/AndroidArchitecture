package com.androidarchitecture.data.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.androidarchitecture.core.executor.ThreadExecutor
import com.androidarchitecture.data.UserDataSource
import com.androidarchitecture.entity.User

class UserRepository constructor(userRepositoryFactory: UserRepositoryFactory, private var mThreadExecutor: ThreadExecutor) : UserDataSource {

    private val userNetAPI = userRepositoryFactory.createUserNetAPI()
    private val userLocalAPI = userRepositoryFactory.createUserLocalAPI()

    //region UserDataSource
    override fun loadUserInfoById(userId: Int): LiveData<User> {
        val result = MutableLiveData<User>()

        mThreadExecutor.execute {
            val userLocal = userLocalAPI.findById(userId)

            if (userLocal != null) {
                result.postValue(userLocal)
            } else {
                userNetAPI.loadUserById(userId).observeForever {
                    result.postValue(it)
                }
            }
        }

        return result
    }

    override fun saveUser(user: User) {
        mThreadExecutor.execute { userLocalAPI.saveUser(user) }
    }
    //endregion
}