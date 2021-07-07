package com.admin.mylectionlearn2.domain

import com.admin.mylectionlearn.domain.model.Post
import com.admin.mylectionlearn2.domain.model.PostDomainModel

interface PostInteractor {
    suspend fun getPost(): PostDomainModel
}