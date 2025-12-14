package com.devcoze.apm.sdk.crash


import android.app.Application
import com.devcoze.apm.sdk.api.SdkModule
import com.devcoze.apm.sdk.common.SdkLogger

class CrashModule : SdkModule {

    override val name: String = "Crash"

    private var defaultHandler: Thread.UncaughtExceptionHandler? = null

    override fun onInit(app: Application) {
        defaultHandler = Thread.getDefaultUncaughtExceptionHandler()
        Thread.setDefaultUncaughtExceptionHandler { thread, throwable ->
            try {
                handleCrash(thread, throwable)
            } catch (e: Throwable) {
                // 防止 SDK 自己崩
            } finally {
                // 交给系统 / 原 handler
                defaultHandler?.uncaughtException(thread, throwable)
            }
        }

        SdkLogger.d("CrashModule init")
    }

    override fun onStart() {
        // nothing
    }

    private fun handleCrash(thread: Thread, throwable: Throwable) {
        SdkLogger.e(
            "Java crash in thread=${thread.name}",
            throwable
        )
        // 后面这里接：落盘 / 上报
    }
}
