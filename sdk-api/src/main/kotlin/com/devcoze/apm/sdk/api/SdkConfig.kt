package com.devcoze.apm.sdk.api

class SdkConfig internal constructor(
    val modules: List<SdkModule>
){

    class Builder {
        private val modules = mutableListOf<SdkModule>()

        fun addModule(module: SdkModule) = apply {
            modules += module
        }

        fun build(): SdkConfig = SdkConfig(modules)
    }

}