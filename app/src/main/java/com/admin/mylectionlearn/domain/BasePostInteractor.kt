package com.admin.mylectionlearn.domain

import com.admin.mylectionlearn.data.mapper.Mapper
import com.admin.mylectionlearn.domain.model.Post
import com.admin.mylectionlearn.domain.repository.PostRepository
import java.io.IOException

class BasePostInteractor(
    private val postRepository: PostRepository,
    private val handleExceptionFactory: HandleExceptionFactory
): PostInteractor {
    override  fun getPost(): Post {
        return try {
            val postSuccess = postRepository.getPost().map(Mapper.MapperFromPostDataToPostSuccess())
            postSuccess
        } catch (e: IOException) {
            val errorMessage = handleExceptionFactory.handle(e)
            Post.Failure(errorMessage)
        }
    }
}