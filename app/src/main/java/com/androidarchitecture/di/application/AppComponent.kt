package com.androidarchitecture.di.application

import android.content.SharedPreferences
import com.androidarchitecture.App
import com.androidarchitecture.BuildConfig
import com.androidarchitecture.core.executor.ThreadExecutor
import com.androidarchitecture.data.TaskDataSource
import com.androidarchitecture.data.UserDataSource
import com.androidarchitecture.di.BaseComponent
import com.androidarchitecture.di.application.auth.AuthModule
import com.androidarchitecture.di.application.data.DataCreatorModule
import com.androidarchitecture.di.application.data.DataModule
import com.androidarchitecture.di.application.network.BaseNetworkModule
import com.androidarchitecture.view.activity.LoginActivity
import com.androidarchitecture.view.fragment.MainFragment
import dagger.Component
import javax.inject.Singleton


/**
 * A component whose lifetime is the life of the application.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, DataModule::class))
interface AppComponent : BaseComponent {

    fun inject(app: App)

    fun inject(loginActivity: LoginActivity)

    fun inject(mainFragment: MainFragment)

    fun sharedPrefs(): SharedPreferences

    fun sharedSecurePrefs(): SharedPreferences

    fun threadExecutor(): ThreadExecutor

    fun userDataSource(): UserDataSource

    fun taskDataSource(): TaskDataSource

    //region Builder
    object Builder {
        fun build(app: App): AppComponent {
            return DaggerAppComponent
                    .builder()
                    .appModule(AppModule(app))
                    .authModule(AuthModule())
                    .baseNetworkModule(BaseNetworkModule(BuildConfig.API_ENDPOINT))
                    .dataCreatorModule(DataCreatorModule())
                    .dataModule(DataModule())
                    .build()
        }
    }
    //endregion
}