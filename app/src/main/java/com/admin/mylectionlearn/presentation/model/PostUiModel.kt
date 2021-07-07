package com.admin.mylectionlearn.presentation.model

import com.admin.mylectionlearn.presentation.Communication

abstract class PostUiModel(
    private val title: String,
    private val body: String) {

    open fun text() =  "title $title,body $body"

    fun show(communication: Communication) = communication.show(this)
}

class BasePostUiModel(
    title: String,
    body: String
): PostUiModel(title, body) {

}

class FailedPostUiModel(
    text: String
): PostUiModel(text,"") {

}