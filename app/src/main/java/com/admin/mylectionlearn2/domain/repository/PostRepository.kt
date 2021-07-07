package com.admin.mylectionlearn2.domain.repository

import com.admin.mylectionlearn2.data.model.PostDataModel

interface PostRepository {
    suspend fun getPost(): PostDataModel
}