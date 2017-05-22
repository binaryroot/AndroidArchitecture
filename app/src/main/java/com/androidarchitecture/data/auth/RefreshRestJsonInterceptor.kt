package com.androidarchitecture.data.auth

import com.androidarchitecture.utility.NetworkUtils

import java.io.IOException

import javax.inject.Inject

import okhttp3.Interceptor
import okhttp3.Response

class RefreshRestJsonInterceptor @Inject
constructor(private val mAuthorizationService: AuthorizationService,
            private val mNetworkUtility: NetworkUtils) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val response = chain.proceed(original)
        if (mNetworkUtility.isNotAuthorized(response)) {

            //Renew token
            val newToken = mAuthorizationService.refreshToken

            if (newToken != null) {
                mAuthorizationService.mTokenStore.saveUserToken(newToken)
                // Add new header to rejected request and retry it
                return chain.proceed(response.request().newBuilder()
                        .removeHeader("AUTHORIZATION")
                        .addHeader("AUTHORIZATION", newToken.accessToken)
                        .build())
            }
        }

        return response
    }
}
