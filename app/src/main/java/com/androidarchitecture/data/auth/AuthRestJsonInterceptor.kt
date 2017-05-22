package com.androidarchitecture.data.auth

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject

class AuthRestJsonInterceptor @Inject
constructor(private val mAuthorizationService: AuthorizationService) : Interceptor {

    companion object {
        private val CONTENT_TYPE_JSON = "application/json; charset=utf-8"
    }

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()

        // Customize the request
        val builder = original.newBuilder()
                .header("CONTENT_TYPE", CONTENT_TYPE_JSON)

        val token = mAuthorizationService.mTokenStore.userToken
        if (token != null) {
            builder.header("AUTHORIZATION", token.accessToken)
        }

        val request = builder.build()

        // Customize or return the response
        return chain.proceed(request)
    }
}
