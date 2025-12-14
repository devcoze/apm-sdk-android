package com.devcoze.apm.sdk.common

import java.util.concurrent.Executors


object SdkExecutor {

    val ioExecutor = Executors.newSingleThreadExecutor { r ->
        Thread(r, "apm-io").apply { isDaemon = true }
    }

}