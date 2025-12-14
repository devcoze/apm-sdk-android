package com.devcoze.apm.sdk.common

import android.util.Log

object SdkLogger {

    private const val TAG = "DevozeAPM"

    fun d(msg: String) {
        Log.d(TAG, msg)
    }

    fun e(msg: String, tr: Throwable? = null) {
        Log.e(TAG, msg, tr)
    }

}
