package com.androidarchitecture.data.auth

import android.content.SharedPreferences

import com.androidarchitecture.entity.auth.Token
import com.google.gson.GsonBuilder

class TokenStore constructor( private val mSecureSharedPreferences: SharedPreferences) {

    companion object {
        var TOKEN_NAME: String = "TOKEN"
    }

    internal val userToken: Token?
        @Synchronized get() {
            val gson = GsonBuilder().serializeNulls().create()
            val json = mSecureSharedPreferences.getString(TOKEN_NAME, "")
            return gson.fromJson(json, Token::class.java)
        }

    @Synchronized internal fun saveUserToken(token: Token) {
        mSecureSharedPreferences.edit()
                .putString(TOKEN_NAME,
                        GsonBuilder()
                                .serializeNulls()
                                .create()
                                .toJson(token))
                .apply()
    }

    @Synchronized internal fun deleteUserToken() {
        mSecureSharedPreferences.edit()
                .putString(TOKEN_NAME, "")
                .clear()
                .apply()
    }
}
