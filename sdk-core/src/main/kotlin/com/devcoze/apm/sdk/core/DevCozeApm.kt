package com.devcoze.apm.sdk.core

import android.app.Application
import com.devcoze.apm.sdk.api.SdkConfig
import com.devcoze.apm.sdk.common.SdkContext
import com.devcoze.apm.sdk.common.SdkExecutor
import com.devcoze.apm.sdk.common.SdkLogger

object DevCozeApm {

    @Volatile
    private var initialized = false

    fun init(app: Application, config: SdkConfig) {
        if (initialized) return

        initialized = true

        SdkContext.init(app)
        SdkLogger.d("APM init start")

        // 模块 init（主线程，轻量）
        config.modules.forEach {
            runCatching {
                it.onInit(app)
                SdkLogger.d("${it.name} init done")
            }.onFailure { e ->
                SdkLogger.e("${it.name} init error", e)
            }
        }

        // 模块 start（后台线程）
        SdkExecutor.ioExecutor.execute {
            config.modules.forEach {
                runCatching {
                    it.onStart()
                    SdkLogger.d("${it.name} start done")
                }.onFailure { e ->
                    SdkLogger.e("${it.name} start error", e)
                }
            }
        }
    }
}
