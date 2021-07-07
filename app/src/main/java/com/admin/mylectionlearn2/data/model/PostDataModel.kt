package com.admin.mylectionlearn2.data.model

import com.admin.mylectionlearn.data.mapper.Mapper
import com.admin.mylectionlearn2.core.Abstract
import com.admin.mylectionlearn2.data.mapper.MapFromPostDataModelToPostDomainModel
import com.admin.mylectionlearn2.domain.model.PostDomainModel
import java.io.IOException

sealed class PostDataModel(): Abstract.Object<PostDomainModel,MapFromPostDataModelToPostDomainModel>() {
    class Success(
        private val id: Int,
        private val title: String,
        private val body: String
    ): PostDataModel() {
        override fun map(mapper: MapFromPostDataModelToPostDomainModel): PostDomainModel
            = mapper.map(id,title,body)
    }

    class Failure(
        private val e: IOException
    ): PostDataModel() {
        override fun map(mapper: MapFromPostDataModelToPostDomainModel): PostDomainModel
            = mapper.map(e)
    }
}