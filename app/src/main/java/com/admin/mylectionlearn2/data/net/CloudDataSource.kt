package com.admin.mylectionlearn2.data.net

import com.admin.mylectionlearn.data.DataSource
import com.admin.mylectionlearn.data.net.model.PostServerModel
import com.admin.mylectionlearn.domain.NoConnectionException
import com.admin.mylectionlearn.domain.ServiceUnavailableException
import java.net.UnknownHostException


interface CloudDataSource: DataSource<PostServerModel> {

    class BaseCloudDataSource: CloudDataSource {
        private val dao = ""

        // FIXME: 06.07.2021 add coroutines and add dispatcher IO
        override suspend fun fetchPost(): PostServerModel {
            return try {
                PostServerModel(1,"title1","body1")
            } catch (e: Exception) {
                val myException = when (e) {
                    is UnknownHostException -> NoConnectionException()
                    else -> ServiceUnavailableException()
                }
                throw myException
            }
        }
    }
}