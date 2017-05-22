package com.androidarchitecture.data.auth

import android.text.TextUtils
import com.androidarchitecture.BuildConfig
import com.androidarchitecture.entity.auth.GrantType
import com.androidarchitecture.entity.auth.Token
import com.androidarchitecture.utility.L
import retrofit2.Retrofit
import java.io.IOException

class AuthorizationService
constructor(internal val mTokenStore: TokenStore, retrofit: Retrofit) {

    private val mService: AuthorizationServiceContract
            = retrofit.create(AuthorizationServiceContract::class.java)

    internal val refreshToken: Token?
        @Synchronized get() {
            var newToken: Token? = null
            val token = mTokenStore.userToken
            try {
                if (TextUtils.isEmpty(token!!.refreshToken)) {
                    return null
                }

                val call = mService.getRefreshToken(GrantType.GR_REFRESH_TOKEN,
                        token.refreshToken,
                        BuildConfig.API_CONSUMER_KEY)

                val response = call.execute()
                newToken = response.body()

                mTokenStore.saveUserToken(newToken)

            } catch (e: IOException) {
                L.e(e.message, e)
            }

            return newToken
        }

    @Synchronized fun getPasswordAccessToken(username: String, password: String): Token? {
        val call = mService.getPasswordToken(GrantType.GR_PASSWORD, username,
                password, BuildConfig.API_CONSUMER_KEY)

        val response = call.execute()
        val token = response.body()

        mTokenStore.saveUserToken(token)

        return token
    }
}
