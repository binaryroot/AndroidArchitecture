package com.androidarchitecture.di.application.network

import com.androidarchitecture.data.auth.AuthRestJsonInterceptor
import com.androidarchitecture.data.auth.AuthorizationService
import com.androidarchitecture.data.auth.RefreshRestJsonInterceptor
import com.androidarchitecture.data.auth.TokenStore
import com.androidarchitecture.di.application.auth.AuthModule
import com.androidarchitecture.di.application.auth.AuthRetrofitQualifier
import com.androidarchitecture.utility.NetworkUtils
import javax.inject.Named
import javax.inject.Singleton

import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Provides base network dependencies
 */
@Module(includes = arrayOf(AuthModule::class))
class BaseNetworkModule(private val mBaseUrl: String) {

    @Singleton
    @Provides
    internal fun provideNetworkUtility(): NetworkUtils {
        return NetworkUtils()
    }

    @Singleton
    @Provides
    internal fun provideGSONConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Singleton
    @Provides
    internal fun provideHttpLogginInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BASIC)
    }

    @Singleton
    @Provides
    internal fun provideOkHttpClient(@Named("AuthInterceptor") authInterceptor: Interceptor,
                                     @Named("RefreshAuthInterceptor") refreshInterceptor: Interceptor,
                                     loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor(authInterceptor)
                .addInterceptor(refreshInterceptor)
                .build()
    }

    @Singleton
    @Provides
    internal fun getBaseRetrofit(client: OkHttpClient, factory: GsonConverterFactory): Retrofit {
        return Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .client(client)
                .addConverterFactory(factory)
                .build()
    }

    @Singleton
    @Provides
    @AuthRetrofitQualifier
    internal fun getAuthRetrofit(factory: GsonConverterFactory): Retrofit {
        return Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .addConverterFactory(factory)
                .build()
    }

    @Singleton
    @Provides
    internal fun getAuthService(store: TokenStore, @AuthRetrofitQualifier retrofit: Retrofit): AuthorizationService {
        return AuthorizationService(store, retrofit)
    }

    @Singleton
    @Provides
    @Named("AuthInterceptor")
    internal fun provideHttpAuthInterceptor(authorizationService: AuthorizationService): Interceptor {
        return AuthRestJsonInterceptor(authorizationService)
    }

    @Singleton
    @Provides
    @Named("RefreshAuthInterceptor")
    internal fun provideHttpRefreshAuthInterceptor(authorizationService: AuthorizationService,
                                                   utility: NetworkUtils): Interceptor {
        return RefreshRestJsonInterceptor(authorizationService, utility)
    }
}
