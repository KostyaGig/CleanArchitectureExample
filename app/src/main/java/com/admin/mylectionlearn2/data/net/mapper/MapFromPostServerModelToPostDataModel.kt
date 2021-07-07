package com.admin.mylectionlearn2.data.net.mapper

import com.admin.mylectionlearn2.data.model.PostDataModel
import com.admin.mylectionlearn2.core.Abstract

interface MapFromPostServerModelToPostDataModel: Abstract.Mapper {
    fun map(id: Int, title: String, body: String): PostDataModel.Success

    class MapperFromPostServerModelToPostDataModelBase: MapFromPostServerModelToPostDataModel {
        override fun map(id: Int, title: String, body: String): PostDataModel.Success
            = PostDataModel.Success(id, title, body)
    }
}