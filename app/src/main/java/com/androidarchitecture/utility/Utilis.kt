package com.androidarchitecture.utility

import android.app.Activity
import android.app.Fragment
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.widget.Toast
import com.androidarchitecture.view.model.TaskViewModel

/**
 * Created by binary on 8/7/17.
 */

fun Activity.toast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}

fun Fragment.toast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(activity, message, duration).show()
}

fun android.support.v4.app.Fragment.toast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(context, message, duration).show()
}

fun <T : ViewModel> android.support.v4.app.Fragment.getViewModel(modelClass: Class<T>): T {
    return ViewModelProviders.of(this).get(modelClass)
}

