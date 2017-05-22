package com.androidarchitecture.data.repository

import android.content.Context
import com.androidarchitecture.data.auth.AuthorizationService
import com.androidarchitecture.data.local.AppDatabase
import com.androidarchitecture.data.local.user.UserLocalAPI
import com.androidarchitecture.data.net.user.RetrofitUserAPI
import com.androidarchitecture.data.net.user.UserNetAPI
import retrofit2.Retrofit

class UserRepositoryFactory constructor(private var mContext: Context,
                                        private var mRetrofit: Retrofit,
                                        private var mAuthorizationService: AuthorizationService,
                                        private var mAppDatabase: AppDatabase) {

    fun createUserNetAPI(): UserNetAPI {
        return RetrofitUserAPI(mContext, mAuthorizationService, mRetrofit)
    }

    fun createUserLocalAPI(): UserLocalAPI {
        return mAppDatabase.userDao()
    }
}