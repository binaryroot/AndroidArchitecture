package com.androidarchitecture

import android.app.Application
import com.androidarchitecture.di.component.AppComponent
import com.androidarchitecture.di.component.DaggerAppComponent
import com.androidarchitecture.di.module.AppModule

/**
 * Created by binary on 5/19/17.
 */
class App: Application() {

    var appComponent: AppComponent? = null

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    fun appComponent(): AppComponent? = appComponent

    //region Utility API
    fun initDagger() {
        appComponent = DaggerAppComponent
                .builder()
                .appModule( AppModule(this))
                .build();
    }
    //endregion
}