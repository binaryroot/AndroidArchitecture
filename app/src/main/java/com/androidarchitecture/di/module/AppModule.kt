package com.androidarchitecture.di.module

import android.app.Application
import android.arch.persistence.room.Room

import android.content.Context
import com.androidarchitecture.data.local.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import com.androidarchitecture.core.executor.JobExecutor
import com.androidarchitecture.core.executor.ThreadExecutor



/**
 * Created by binary on 5/18/17.
 */
@Module
class AppModule(val app: Application) {

    @Provides
    @Singleton
    fun provideContext() : Context = app

    @Provides
    @Singleton
    fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor {
        return jobExecutor
    }

    @Provides
    @Singleton
    fun providerAppDatabase(): AppDatabase {
        return Room.databaseBuilder(app.applicationContext,
                AppDatabase::class.java, "database").build();
    }
}