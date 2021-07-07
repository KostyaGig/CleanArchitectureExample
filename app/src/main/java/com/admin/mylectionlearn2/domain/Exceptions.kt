package com.admin.mylectionlearn2.domain

import com.admin.mylectionlearn.core.ResourceManager
import com.admin.mylectionlearn.presentation.Error
import java.io.IOException

class NoConnectionException(): IOException()
class ServiceUnavailableException(): IOException()

interface HandleExceptionFactory {
    fun handle(e: IOException): String

    class BaseHandleExceptionFactory(
        private val resourceManager: ResourceManager
    ) : HandleExceptionFactory {
        override fun handle(e: IOException): String {
            return when (e) {
                is NoConnectionException -> Error.NoConnectionError(resourceManager).getMessage()
                else -> Error.ServiceUnavailableError(resourceManager).getMessage()
            }
        }
    }
}
