package com.androidarchitecture.core

import android.content.Context
import com.androidarchitecture.di.BaseComponent
import com.androidarchitecture.di.activity.ActivityComponent

/**
 * Created by binary on 8/7/17.
 */
abstract class BaseInjectFragment<in E : BaseComponent> : BaseFragment() {

    abstract fun inject(component: E)

    //region BaseFragment
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        val baseComponent =  (context as? BaseInjectActivity<*>)?.getComponent() as E
        baseComponent.let {
            inject(it)
        }
    }
    //endregion
}