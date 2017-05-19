package com.androidarchitecture.core

import android.app.Activity
import android.arch.lifecycle.LifecycleFragment
import com.androidarchitecture.di.component.AppComponent

/**
 * Created by binary on 5/18/17.
 */
abstract class BaseFragment : LifecycleFragment(), LoadingUiHandler {

    private var loadingUiHandler:LoadingUiHandler? = null

    //region LifecycleFragment
    override fun onAttach(activity: Activity?) {
        super.onAttach(activity)
        if (activity is LoadingUiHandler) {
            loadingUiHandler = activity
        }
    }
    //endregion

    //region BaseFragment
    /**
     * Returns instance of {@link AppComponent}.
     */
    fun getAppComponent() : AppComponent? = (activity as BaseActivity).getAppComponent()
    //endregion

    //region LoadingUiHandler
    override fun showLoadingDialog(message: String) {
        loadingUiHandler?.showLoadingDialog(message)
    }

    override fun updateLoadingDialog(message: String) {
        loadingUiHandler?.updateLoadingDialog(message)
    }

    override fun hideLoadingDialog() {
        loadingUiHandler?.hideLoadingDialog()
    }
    //endregion

}