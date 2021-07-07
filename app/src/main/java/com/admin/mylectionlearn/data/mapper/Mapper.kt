package com.admin.mylectionlearn.data.mapper

import com.admin.mylectionlearn.data.model.PostDataModel
import com.admin.mylectionlearn.domain.model.Post

interface Mapper<T> {
    fun map(id: Int,title: String,body: String): T

    class MapperFromServerModelToDataModel: Mapper<PostDataModel> {
        override fun map(id: Int, title: String, body: String): PostDataModel
                = PostDataModel(id, title, body)
    }

    class MapperFromRealmModelToDataModel: Mapper<PostDataModel> {
        override fun map(id: Int, title: String, body: String): PostDataModel
                = PostDataModel(id, title, body)
    }

    class MapperFromPostDataToPostSuccess: Mapper<Post.Success> {
        override fun map(id: Int, title: String, body: String): Post.Success = Post.Success(title,body)
    }
}