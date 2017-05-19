package com.androidarchitecture.utility

import android.util.Log

import com.androidarchitecture.BuildConfig

/**
 * Advanced logger
 */
object L {
    /**
     * Prints error message.

     * @param msg message value
     */
    fun e(msg: String) {
        if (BuildConfig.DEBUG) {
            val t = Throwable()
            val elements = t.stackTrace

            val callerClassName = elements[1].className
            val callerMethodName = elements[1].methodName

            Log.e(callerClassName, callerMethodName + " :: " + msg)
        }
    }

    /**
     * Prints error message.

     * @param msg message value
     */
    fun e(msg: String, error: Throwable) {
        if (BuildConfig.DEBUG) {
            val t = Throwable()
            val elements = t.stackTrace

            val callerClassName = elements[1].className
            val callerMethodName = elements[1].methodName

            Log.e(callerClassName, callerMethodName + " :: " + msg, error)
        }
    }

    /**
     * Prints debug message.

     * @param msg message value
     */
    fun d(msg: String) {
        if (BuildConfig.DEBUG) {
            val t = Throwable()
            val elements = t.stackTrace

            val callerClassName = elements[1].className
            val callerMethodName = elements[1].methodName

            Log.d(callerClassName, callerMethodName + " :: " + msg)
        }
    }
}