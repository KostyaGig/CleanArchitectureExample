package com.admin.mylectionlearn.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.admin.mylectionlearn.domain.PostInteractor
import com.admin.mylectionlearn.presentation.Communication

class PostViewModel (
    private val postInteractor: PostInteractor,
    private val communication: Communication
): ViewModel() {

//    fun fetchPost() = postInteractor.getPost().map().show(communication)
}