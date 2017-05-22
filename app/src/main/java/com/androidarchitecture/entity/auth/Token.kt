package com.androidarchitecture.entity.auth

import com.google.gson.annotations.SerializedName

data class Token(@SerializedName("access_token") val accessToken: String?,
                 @SerializedName("token_type") val tokenType: String?,
                 @SerializedName("expires_in") val expiresIn: Long?,
                 @SerializedName("refresh_token") val refreshToken: String?,
                 @SerializedName("id") val id: String?)