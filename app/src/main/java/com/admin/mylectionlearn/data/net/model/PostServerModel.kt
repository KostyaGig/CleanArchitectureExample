package com.admin.mylectionlearn.data.net.model

import com.admin.mylectionlearn.data.mapper.Mapper
import com.admin.mylectionlearn2.data.model.PostDataModel
import com.admin.mylectionlearn2.core.Abstract
import com.admin.mylectionlearn2.data.net.mapper.MapFromPostServerModelToPostDataModel

data class PostServerModel(
    private val id: Int,
    private val title: String,
    private val body: String
): Abstract.Object<PostDataModel.Success,MapFromPostServerModelToPostDataModel>() {
    override fun map(mapper: MapFromPostServerModelToPostDataModel): PostDataModel.Success
        = mapper.map(id,title,body)

}