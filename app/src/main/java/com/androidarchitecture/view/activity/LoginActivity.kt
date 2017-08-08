package com.androidarchitecture.view.activity


import android.os.Bundle
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.widget.Button
import com.androidarchitecture.R
import com.androidarchitecture.core.BaseActivity
import com.androidarchitecture.core.BaseInjectActivity
import com.androidarchitecture.data.UserDataSource
import com.androidarchitecture.di.activity.ActivityComponent
import com.androidarchitecture.di.application.AppComponent
import com.androidarchitecture.view.model.UserViewModel
import javax.inject.Inject

/**
 * A login screen that offers login via email/password.
 */
class LoginActivity : BaseInjectActivity<ActivityComponent>() {

    lateinit var userDataModule: UserViewModel

    // UI references.
    private lateinit var mEmailSignInButton : Button

    //region BaseInjectActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        userDataModule = ViewModelProviders.of(this).get(UserViewModel::class.java)
        getComponent().inject(userDataModule)

        mEmailSignInButton = findViewById(R.id.email_sign_in_button) as Button
        mEmailSignInButton.setOnClickListener {
            userDataModule.getUser(1)?.observe(this@LoginActivity, Observer {
                it?.let {
                    startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                    finish()
                }
            })
        }
    }

    override fun injectActivityComponent(component: AppComponent): ActivityComponent {
        val activityComponent = ActivityComponent.Initializer.init(component)
        return activityComponent
    }
    //endregion
}

