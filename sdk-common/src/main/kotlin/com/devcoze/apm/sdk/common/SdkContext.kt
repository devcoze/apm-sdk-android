package com.devcoze.apm.sdk.common

import android.app.Application
import kotlin.concurrent.Volatile

object SdkContext {

    @Volatile
    private var application: Application? = null

    fun init(app: Application) {
        if (application != null) {
            return
        }
        application = app
    }

    fun get() : Application {
        return application ?: throw IllegalStateException("SdkContext not initialized")
    }

}