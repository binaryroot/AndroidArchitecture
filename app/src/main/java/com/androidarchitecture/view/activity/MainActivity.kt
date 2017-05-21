package com.androidarchitecture.view.activity

import android.os.Bundle
import com.androidarchitecture.R
import com.androidarchitecture.core.BaseActivity
import com.androidarchitecture.view.fragment.MainFragment

class MainActivity : BaseActivity() {

    //region BaseActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFragment(R.id.container, MainFragment.newInstance(), false)
    }
    //endregion
}
