package com.admin.mylectionlearn.domain.repository

import com.admin.mylectionlearn.data.model.PostDataModel

interface PostRepository {
    suspend fun getPost(): PostDataModel
}