package com.admin.mylectionlearn.core

import android.content.Context
import androidx.annotation.StringRes

interface ResourceManager {
    fun provide(@StringRes stringResId: Int): String

    class BaseResourceManager(
        private val context: Context
    ): ResourceManager {
        override fun provide(@StringRes stringResId: Int): String = context.getString(stringResId)
    }
}