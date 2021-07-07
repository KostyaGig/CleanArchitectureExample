package com.admin.mylectionlearn2.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.admin.mylectionlearn2.domain.HandleExceptionFactory
import com.admin.mylectionlearn2.domain.PostInteractor
import com.admin.mylectionlearn2.domain.mapper.MapFromDomainPostModelToUiPostModel
import com.admin.mylectionlearn2.presentation.Communication

class PostViewModel (
    private val postInteractor: PostInteractor,
    private val communication: Communication,
    private val handleExceptionFactory: HandleExceptionFactory
): ViewModel() {

    // FIXME: 07.07.2021 add viewmodelscope
//    fun fetchPost() = postInteractor.getPost().map(MapFromDomainPostModelToUiPostModel.BaseMapper(communication,handleExceptionFactory))
}