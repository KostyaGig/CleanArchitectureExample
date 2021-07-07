package com.admin.mylectionlearn2.presentation

import com.admin.mylectionlearn.R
import com.admin.mylectionlearn.core.ResourceManager

interface Error {
    fun getMessage(): String

    class NoConnectionError(
        private val resourceManager: ResourceManager
    ): Error {
        override fun getMessage(): String = resourceManager.provide(R.string.no_connection_error_text)
    }

    class ServiceUnavailableError(
        private val resourceManager: ResourceManager
    ): Error {
        override fun getMessage(): String = resourceManager.provide(R.string.service_unavailable_error_text)
    }
}