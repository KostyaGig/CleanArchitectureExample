package com.admin.mylectionlearn.domain

import com.admin.mylectionlearn.domain.model.Post

interface PostInteractor {
    fun getPost(): Post
}