package com.androidarchitecture.data.net.user

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import com.androidarchitecture.entity.User
import com.google.gson.GsonBuilder
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Response


/**
 * Created by binary on 5/18/17.
 */
class RetrofitUserAPI(private var context: Context) : UserNetAPI {

    private val BASE_URL = "https://kronosoft.herokuapp.com/api/v1/"

    private var userApi:API

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
                .build()
        userApi = retrofit.create(API::class.java)
    }

    //region UserNetAPI
    override fun loadUserById(userId: Int): LiveData<User> {
        val result = MutableLiveData<User>()
        userApi.loadUser().enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>?, response: Response<User>?) {
                response?.let {
                    result.postValue(it.body())
                }
            }

            override fun onFailure(call: Call<User>?, t: Throwable?) {
            }

        })
        return result
    }
    //endregion


    internal interface API {
        @GET("status/user")
        fun loadUser(): Call<User>
    }
}