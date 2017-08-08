package com.androidarchitecture.di.application.auth

import android.content.SharedPreferences
import com.androidarchitecture.data.auth.TokenStore
import com.androidarchitecture.di.application.qualifier.SecurePrefQualifier
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Singleton
@Module
internal class AuthModule {

    @Singleton
    @Provides
    fun getTokenStore(@SecurePrefQualifier preferences: SharedPreferences): TokenStore {
        return TokenStore(preferences)
    }
}
