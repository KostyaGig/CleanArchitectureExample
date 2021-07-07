package com.admin.mylectionlearn2.data.mapper

import com.admin.mylectionlearn2.core.Abstract
import com.admin.mylectionlearn2.domain.model.PostDomainModel
import java.io.IOException

interface MapFromPostDataModelToPostDomainModel: Abstract.Mapper {
    fun map(id: Int, title: String, body: String): PostDomainModel
    fun map(e: IOException): PostDomainModel

    class BaseMapper(): MapFromPostDataModelToPostDomainModel {
        override fun map(id: Int, title: String, body: String): PostDomainModel = PostDomainModel.Success(id, title, body)
        override fun map(e: IOException): PostDomainModel = PostDomainModel.Failure(e)
    }
}