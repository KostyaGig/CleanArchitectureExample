package com.admin.mylectionlearn2.domain

import com.admin.mylectionlearn2.data.mapper.MapFromPostDataModelToPostDomainModel
import com.admin.mylectionlearn2.domain.repository.PostRepository
import com.admin.mylectionlearn2.domain.model.PostDomainModel
import java.io.IOException

class BasePostInteractor(
    private val postRepository: PostRepository,
): PostInteractor {
    override  suspend fun getPost(): PostDomainModel {
        return try {
            val postSuccess = postRepository.getPost()
            postSuccess.map(MapFromPostDataModelToPostDomainModel.BaseMapper())
        } catch (e: IOException) {
            PostDomainModel.Failure(e)
        }
    }
}