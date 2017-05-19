package com.androidarchitecture.di.component

import android.content.Context
import com.androidarchitecture.data.UserDataSource
import com.androidarchitecture.di.module.AppModule
import com.androidarchitecture.di.module.DataModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by binary on 5/18/17.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, DataModule::class))
interface AppComponent {

    fun getContext() : Context


    fun userDataSource(): UserDataSource
}