package com.androidarchitecture.data.repository

import android.content.Context
import com.androidarchitecture.data.local.AppDatabase
import com.androidarchitecture.data.local.user.UserLocalAPI
import com.androidarchitecture.data.net.user.RetrofitUserAPI
import com.androidarchitecture.data.net.user.UserNetAPI
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by binary on 5/18/17.
 */
@Singleton
class UserRepositoryFactory @Inject constructor(var context:Context, private var appDatabase: AppDatabase) {

    fun createUserNetApi() : UserNetAPI {
        return RetrofitUserAPI(context)
    }

    fun createUserLocalAPI(): UserLocalAPI {
        return appDatabase.userDao()
    }
}