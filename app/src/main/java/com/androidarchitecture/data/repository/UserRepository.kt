package com.androidarchitecture.data.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.androidarchitecture.core.executor.ThreadExecutor
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
class UserRepository @Inject constructor(userRepositoryFactory: UserRepositoryFactory, var threadExecutor: ThreadExecutor) : UserDataSource {

    private val userNetApi = userRepositoryFactory.createUserNetApi()
    private val userLocalApi = userRepositoryFactory.createUserLocalAPI()

    //region UserDataSource
    override fun loadUserInfoById(userId: Int): LiveData<User> {
       val result = MutableLiveData<User>()
        threadExecutor.execute {
            val userLocal = userLocalApi.findById(userId)
            if(userLocal != null) {
                result.postValue(userLocal)
            } else {
                userNetApi.loadUserById(userId).observeForever {
                    result.postValue(it)
                }
            }
        }

        return result;
    }

    override fun saveUser(user: User) {
        threadExecutor.execute { userLocalApi.saveUser(user) }
    }
    //endregion
}