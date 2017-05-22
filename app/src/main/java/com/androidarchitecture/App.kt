package com.androidarchitecture

import android.app.Application
import com.androidarchitecture.di.HasComponent
import com.androidarchitecture.di.application.AppComponent

/**
 * Main application instance.
 */
class App : Application(), HasComponent<AppComponent> {

    private var appComponent: AppComponent = AppComponent.Builder.build(this)

    //region Application
    override fun onCreate() {
        super.onCreate()
    }
    //endregion

    //region HasComponent<AppComponent>
    override fun getComponent(): AppComponent {
        return appComponent
    }
    //endregion
}