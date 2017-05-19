package com.androidarchitecture.core

/**
 * Created by binary on 5/18/17.
 */
interface LoadingUiHandler  {

    fun showLoadingDialog(message: String)

    fun updateLoadingDialog(message: String)

    fun hideLoadingDialog();
}