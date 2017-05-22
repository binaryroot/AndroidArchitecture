package com.androidarchitecture.view.activity


import android.os.Bundle
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.widget.Button
import com.androidarchitecture.R
import com.androidarchitecture.core.BaseActivity
import com.androidarchitecture.data.UserDataSource
import com.androidarchitecture.view.model.UserViewModel
import javax.inject.Inject

/**
 * A login screen that offers login via email/password.
 */
class LoginActivity : BaseActivity() {

    @Inject
    lateinit var userDataSource: UserDataSource

    // UI references.
    private lateinit var mEmailSignInButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        getAppComponent().inject(this@LoginActivity)
        mEmailSignInButton = findViewById(R.id.email_sign_in_button) as Button

        val userDataModule = ViewModelProviders.of(this@LoginActivity).get(UserViewModel::class.java)
        userDataModule.userDataSource = userDataSource

        mEmailSignInButton.setOnClickListener {

            userDataModule.getUser(1)?.observe(this@LoginActivity, Observer {
                it?.let {
                    startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                    finish()
                }
            })
        }
    }
}

