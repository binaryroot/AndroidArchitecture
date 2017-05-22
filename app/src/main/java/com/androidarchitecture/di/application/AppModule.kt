package com.androidarchitecture.di.application

import android.arch.persistence.room.Room
import android.content.Context
import android.content.SharedPreferences
import com.androidarchitecture.App
import com.androidarchitecture.core.executor.JobExecutor
import com.androidarchitecture.core.executor.ThreadExecutor
import com.androidarchitecture.data.local.AppDatabase
import com.securepreferences.SecurePreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


/**
 * Provides application dependencies.
 */
@Module
class AppModule(val app: App) {

    @Provides
    @Singleton
    fun provideApplication(): App = app

    @Provides
    @Singleton
    fun provideContext(): Context = app

    @Provides
    @Singleton
    fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor {
        return jobExecutor
    }

    @Provides
    @Singleton
    internal fun provideSharedPreferences(@Singleton context: Context): SharedPreferences {
        return context.getSharedPreferences("App", Context.MODE_PRIVATE)
    }


    @Provides
    @Singleton
    @SecurePrefQualifier
    internal fun provideSecureSharedPreferences(@Singleton context: Context): SharedPreferences {
        return SecurePreferences(context)
    }

    @Provides
    @Singleton
    fun providerAppDatabase(): AppDatabase {
        return Room.databaseBuilder(app.applicationContext,
                AppDatabase::class.java, "database").build()
    }
}