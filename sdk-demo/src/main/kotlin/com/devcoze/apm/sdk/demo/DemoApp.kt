package com.devcoze.apm.sdk.demo

import android.app.Application
import com.devcoze.apm.sdk.api.SdkConfig
import com.devcoze.apm.sdk.core.DevCozeApm
import com.devcoze.apm.sdk.crash.CrashModule

class DemoApp : Application() {

    override fun onCreate() {
        super.onCreate()

        DevCozeApm.init(
            this,
            SdkConfig.Builder()
                .addModule(CrashModule())
                .build()
        )
    }

}
