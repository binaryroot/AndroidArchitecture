package com.androidarchitecture.di.application

import com.androidarchitecture.App
import com.androidarchitecture.core.executor.ThreadExecutor
import com.androidarchitecture.data.TaskDataSource
import com.androidarchitecture.data.UserDataSource
import com.androidarchitecture.di.BaseComponent
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

    fun threadExecutor(): ThreadExecutor

    fun userDataSource(): UserDataSource

    fun taskDataSource(): TaskDataSource

    //region Builder
    object Builder {
        fun build(app: App): AppComponent {
            return DaggerAppComponent
                    .builder()
                    .appModule(AppModule(app))
                    .build()
        }
    }
    //endregion
}