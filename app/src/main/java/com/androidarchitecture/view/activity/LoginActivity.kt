package com.androidarchitecture.view.activity


import android.os.Bundle
import android.view.View
import android.widget.AutoCompleteTextView

import android.widget.EditText
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.widget.Button
import com.androidarchitecture.R
import com.androidarchitecture.core.BaseActivity
import com.androidarchitecture.view.model.UserViewModel

/**
 * A login screen that offers login via email/password.
 */
class LoginActivity : BaseActivity() {

    // UI references.
    private lateinit var mEmailSignInButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        mEmailSignInButton = findViewById(R.id.email_sign_in_button) as Button

        val userDataModule = ViewModelProviders.of(this@LoginActivity).get(UserViewModel::class.java)
        getAppComponent()?.let {
            userDataModule.userDataSource = it.userDataSource()
        }

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

