package com.admin.mylectionlearn.domain.model

import com.admin.mylectionlearn.presentation.model.BasePostUiModel
import com.admin.mylectionlearn.presentation.model.FailedPostUiModel
import com.admin.mylectionlearn.presentation.model.PostUiModel

sealed class Post {

    abstract fun map(): PostUiModel

    class Success(
        private val title: String,
        private val body: String
    ): Post() {
        override fun map(): PostUiModel = BasePostUiModel(title,body)
    }

    class Failure(
        private val text: String
    ) : Post() {
        override fun map(): PostUiModel = FailedPostUiModel(text)
    }
}