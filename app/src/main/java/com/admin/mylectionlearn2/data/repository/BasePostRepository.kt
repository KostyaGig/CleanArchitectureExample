package com.admin.mylectionlearn2.data.repository

import com.admin.mylectionlearn.data.cache.CacheDataSource


import com.admin.mylectionlearn2.data.model.PostDataModel
import com.admin.mylectionlearn2.data.net.CloudDataSource
import com.admin.mylectionlearn2.data.net.mapper.MapFromPostServerModelToPostDataModel
import com.admin.mylectionlearn2.domain.repository.PostRepository
import java.io.IOException

class BasePostRepository(
    private val cacheDataSource: CacheDataSource,
    private val cloudDataSource: CloudDataSource,
): PostRepository {
    private var getFromCache = false
    override suspend fun getPost(): PostDataModel {
        return try {
                val postServerModel = cloudDataSource.fetchPost()
                //Map from server post object to post data object
                postServerModel.map(MapFromPostServerModelToPostDataModel.MapperFromPostServerModelToPostDataModelBase())
        } catch (e: IOException) {
            throw e
        }
    }
}