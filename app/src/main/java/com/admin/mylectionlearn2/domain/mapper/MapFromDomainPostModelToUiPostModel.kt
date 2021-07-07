package com.admin.mylectionlearn2.domain.mapper

import com.admin.mylectionlearn2.domain.HandleExceptionFactory
import com.admin.mylectionlearn2.presentation.Communication
import com.admin.mylectionlearn2.core.Abstract
import com.admin.mylectionlearn2.domain.model.PostDomainModel
import com.admin.mylectionlearn2.presentation.model.PostUiModel
import java.io.IOException

interface MapFromDomainPostModelToUiPostModel: Abstract.Mapper {
        fun map(id: Int, title: String, body: String): PostUiModel
        fun map(e: IOException): PostUiModel

        class BaseMapper(
            private val communication: Communication,
            private val handleExceptionFactory: HandleExceptionFactory
        ): MapFromDomainPostModelToUiPostModel {
            override fun map(id: Int, title: String, body: String): PostUiModel = PostUiModel.Success(id,title,body,communication)

            override fun map(e: IOException): PostUiModel
                = PostUiModel.Failure(handleExceptionFactory.handle(e),communication)
        }
}