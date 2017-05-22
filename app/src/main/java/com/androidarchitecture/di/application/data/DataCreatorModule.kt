package com.androidarchitecture.di.application.data

import com.androidarchitecture.di.application.network.BaseNetworkModule

@dagger.Module(includes = arrayOf(BaseNetworkModule::class))
class DataCreatorModule {

    @dagger.Provides
    @javax.inject.Singleton
    fun providerUserDataSourceFactory(context: android.content.Context, retrofit: retrofit2.Retrofit,
                                      authService: com.androidarchitecture.data.auth.AuthorizationService,
                                      appDataBase: com.androidarchitecture.data.local.AppDatabase): com.androidarchitecture.data.repository.UserRepositoryFactory {
        return com.androidarchitecture.data.repository.UserRepositoryFactory(context, retrofit, authService, appDataBase);
    }

    @dagger.Provides
    @javax.inject.Singleton
    fun providerTaskDataSourceFactory(appDataBase: com.androidarchitecture.data.local.AppDatabase): com.androidarchitecture.data.repository.TaskRepositoryFactory {
        return com.androidarchitecture.data.repository.TaskRepositoryFactory(appDataBase)
    }
}