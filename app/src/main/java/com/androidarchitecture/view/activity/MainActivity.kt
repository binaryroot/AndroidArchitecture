package com.androidarchitecture.view.activity

import android.os.Bundle
import com.androidarchitecture.R
import com.androidarchitecture.core.BaseActivity
import com.androidarchitecture.core.BaseInjectActivity
import com.androidarchitecture.di.activity.ActivityComponent
import com.androidarchitecture.di.application.AppComponent
import com.androidarchitecture.view.fragment.MainFragment

class MainActivity : BaseInjectActivity<ActivityComponent>() {

    //region BaseActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFragment(R.id.container, MainFragment.newInstance(), false)
    }

    override fun injectActivityComponent(component: AppComponent): ActivityComponent {
        val activityComponent = ActivityComponent.Initializer.init(component)
        return activityComponent
    }
    //endregion
}
