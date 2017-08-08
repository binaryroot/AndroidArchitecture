package com.androidarchitecture.core

import android.arch.lifecycle.LifecycleFragment
import android.content.Context
import com.androidarchitecture.di.application.AppComponent
import android.os.Bundle
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View


/**
 * Created by binary on 5/18/17.
 */
abstract class BaseFragment : LifecycleFragment(), LoadingUiHandler {

    private lateinit var loadingUiHandler:LoadingUiHandler

    //region LifecycleFragment
    override fun onAttach(context: Context?) {
        super.onAttach(context)

        if (context is LoadingUiHandler) {
            loadingUiHandler = context

        }
    }
    //endregion

    //region BaseFragment
    /**
     * Returns instance of {@link AppComponent}.
     */

    protected abstract fun getContentViewID(): Int

    protected abstract fun initView(savedInstanceState: Bundle?)

    override fun onCreateView(inflater: LayoutInflater?,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(getContentViewID(), container, false)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(savedInstanceState)
    }
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