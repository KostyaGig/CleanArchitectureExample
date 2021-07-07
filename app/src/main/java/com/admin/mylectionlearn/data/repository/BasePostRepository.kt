package com.admin.mylectionlearn.data.repository

import com.admin.mylectionlearn.data.cache.CacheDataSource
import com.admin.mylectionlearn.data.mapper.Mapper
import com.admin.mylectionlearn.data.model.PostDataModel
import com.admin.mylectionlearn.data.net.CloudDataSource
import com.admin.mylectionlearn.domain.repository.PostRepository
import java.io.IOException

class BasePostRepository(
    private val cacheDataSource: CacheDataSource,
    private val cloudDataSource: CloudDataSource,
): PostRepository {
    private var getFromCache = false
    override suspend fun getPost(): PostDataModel {
        return try {
            if (getFromCache) {
                //Map from realm object to post data object
                cacheDataSource.fetchPost().map(Mapper.MapperFromRealmModelToDataModel())
            } else {
                val postServerModel = cloudDataSource.fetchPost()
                //Map from server post object to post data object
                postServerModel.map(Mapper.MapperFromServerModelToDataModel())
            }
        } catch (e: IOException) {
            throw e
        }
    }
}