package com.androidarchitecture.data.net.user

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import com.androidarchitecture.data.auth.AuthorizationService
import com.androidarchitecture.entity.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET

class RetrofitUserAPI(private var mContext: Context,
                      private var mAuthorizationService: AuthorizationService,
                      retrofit: Retrofit) : UserNetAPI {

    private var mUserApi: API = retrofit.create(API::class.java)

    //region UserNetAPI
    override fun login(name: String, password: String): Boolean {
        return mAuthorizationService.getPasswordAccessToken(name, password) != null
    }

    override fun loadUserById(userId: Int): LiveData<User> {
        val result = MutableLiveData<User>()
        mUserApi.loadUser()
                .enqueue(object : Callback<User> {
                    override fun onResponse(call: Call<User>?, response: Response<User>?) {
                        response?.let {
                            result.postValue(it.body())
                        }
                    }

                    override fun onFailure(call: Call<User>?, t: Throwable?) {}
                })

        return result
    }
    //endregion


    internal interface API {
        @GET("status/user")
        fun loadUser(): Call<User>
    }
}