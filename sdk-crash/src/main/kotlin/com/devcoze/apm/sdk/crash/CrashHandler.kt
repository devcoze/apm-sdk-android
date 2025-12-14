package com.devcoze.apm.sdk.crash

import android.content.Context

/**
 * Crash 处理
 */
object CrashHandler : Thread.UncaughtExceptionHandler {

    private var defaultHandler: Thread.UncaughtExceptionHandler? = null
    private lateinit var appContext: Context

    fun install(context: Context) {
        appContext = context.applicationContext
        defaultHandler = Thread.getDefaultUncaughtExceptionHandler()
        Thread.setDefaultUncaughtExceptionHandler(this)
    }

    override fun uncaughtException(t: Thread, e: Throwable) {
        try {

        } catch (t: Throwable) {

        } finally {
            defaultHandler?.uncaughtException(t, e)
        }
    }

}