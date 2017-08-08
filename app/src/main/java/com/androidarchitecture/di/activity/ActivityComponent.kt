package com.androidarchitecture.di.activity

import com.androidarchitecture.di.BaseComponent
import com.androidarchitecture.di.application.AppComponent
import com.androidarchitecture.view.model.TaskViewModel
import com.androidarchitecture.view.model.UserViewModel
import dagger.Component
import com.androidarchitecture.core.BaseActivity
import com.androidarchitecture.view.activity.LoginActivity
import com.androidarchitecture.view.fragment.MainFragment


/**
 * Created by binary on 8/7/17.
 */
@PerActivity
@Component(dependencies = arrayOf(AppComponent::class))
interface ActivityComponent : BaseComponent {

    fun inject(loginActivity: LoginActivity)

    fun inject(mainFragment: MainFragment)

    fun inject(taskViewModel: TaskViewModel)

    fun inject(userViewModel: UserViewModel)

    //region Builder
    object Initializer {

        fun init(appComponent: AppComponent): ActivityComponent {
            return DaggerActivityComponent.builder()
                    .appComponent(appComponent)
                    .build()
        }
    }
    //endregion
}