package com.devcoze.apm.sdk.api

import android.app.Application

interface SdkModule {

    /** 模块名，用于日志 & 管理 */
    val name: String

    /** SDK 初始化阶段 */
    fun onInit(app: Application)

    /** SDK 正式启动 */
    fun onStart()
}