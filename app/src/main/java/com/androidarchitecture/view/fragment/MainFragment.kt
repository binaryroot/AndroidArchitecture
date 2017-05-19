package com.androidarchitecture.view.fragment

import android.support.v4.app.Fragment
import android.os.Bundle
import com.androidarchitecture.R
import com.androidarchitecture.core.BaseFragment

/**
 * Created by binary on 5/20/17.
 */
class MainFragment : BaseFragment() {

    companion object {
        fun newInstance(): Fragment = MainFragment()
    }

    //region BaseFragment
    override fun getContentViewID(): Int = R.layout.fragment_main

    override fun initView(savedInstanceState: Bundle?) {

    }
    //endregion

}