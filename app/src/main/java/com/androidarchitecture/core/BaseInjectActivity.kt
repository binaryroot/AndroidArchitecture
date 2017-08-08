package com.androidarchitecture.core

import com.androidarchitecture.di.BaseComponent
import com.androidarchitecture.di.HasComponent
import com.androidarchitecture.di.application.AppComponent
import com.androidarchitecture.utility.L
import com.androidarchitecture.App
import android.os.Bundle

/**
 * Created by binary on 8/7/17.
 */
abstract class BaseInjectActivity<E : BaseComponent> : BaseActivity(), HasComponent<E> {

    protected  lateinit var mComponent: E

    protected abstract fun injectActivityComponent(component: AppComponent): E

    //region  HasComponent<E>
    override fun getComponent(): E {
        return mComponent
    }
    //endregion

    //region BaseViewModelActivity<T>
    override fun onCreate(savedInstanceState: Bundle?) {
        if (applicationContext is HasComponent<*>) {
            mComponent = injectActivityComponent(getAppComponent())
        } else {
            L.d("Application has no Component!")
        }

        super.onCreate(savedInstanceState)
    }
    //endregion
}