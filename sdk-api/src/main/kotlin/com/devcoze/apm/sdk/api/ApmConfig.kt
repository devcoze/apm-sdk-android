package com.devcoze.apm.sdk.api

class ApmConfig internal constructor(
    val modules: List<SdkModule>
){

    class Builder {
        private val modules = mutableListOf<SdkModule>()

        fun addModule(module: SdkModule) = apply {
            modules += module
        }

        fun build(): ApmConfig = ApmConfig(modules)
    }

}