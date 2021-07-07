package com.admin.mylectionlearn2.domain.model

import com.admin.mylectionlearn.presentation.model.BasePostUiModel
import com.admin.mylectionlearn.presentation.model.FailedPostUiModel
import com.admin.mylectionlearn2.core.Abstract
import com.admin.mylectionlearn2.domain.mapper.MapFromDomainPostModelToUiPostModel
import com.admin.mylectionlearn2.presentation.model.PostUiModel
import java.io.IOException

sealed class PostDomainModel: Abstract.Object<PostUiModel, MapFromDomainPostModelToUiPostModel>() {
    class Success(
        private val id: Int,
        private val title: String,
        private val body: String
    ): PostDomainModel() {
        override fun map(mapper: MapFromDomainPostModelToUiPostModel): PostUiModel
            = mapper.map(id,title,body)
    }

    class Failure(
        private val e: IOException
    ): PostDomainModel() {
        override fun map(mapper: MapFromDomainPostModelToUiPostModel): PostUiModel
            = mapper.map(e)
    }
}