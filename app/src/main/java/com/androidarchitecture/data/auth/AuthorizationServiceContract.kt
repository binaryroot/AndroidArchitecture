package com.androidarchitecture.data.auth

import com.androidarchitecture.entity.auth.Token

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

internal interface AuthorizationServiceContract {

    @FormUrlEncoded
    @POST("/token")
    fun getPasswordToken(
            @Field("grant_type") grantType: String,
            @Field("username") userName: String,
            @Field("password") password: String,
            @Field("client_id") clientId: String
    ): Call<Token>

    @FormUrlEncoded
    @POST("/token")
    fun getRefreshToken(
            @Field("grant_type") grantType: String,
            @Field("refresh_token") refreshToken: String?,
            @Field("client_id") clientId: String
    ): Call<Token>
}