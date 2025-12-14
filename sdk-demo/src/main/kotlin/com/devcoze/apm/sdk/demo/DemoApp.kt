package com.devcoze.apm.sdk.demo

import android.app.Application
import com.devcoze.apm.sdk.api.ApmConfig
import com.devcoze.apm.sdk.core.DevCozeApm
import com.devcoze.apm.sdk.crash.CrashModule

class DemoApp : Application() {

    override fun onCreate() {
        super.onCreate()

        DevCozeApm.init(
            this,
            ApmConfig.Builder()
                .addModule(CrashModule())
                .build()
        )
    }

}
