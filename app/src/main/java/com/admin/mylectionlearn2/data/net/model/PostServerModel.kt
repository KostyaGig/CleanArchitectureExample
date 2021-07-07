package com.admin.mylectionlearn2.data.net.model

import com.admin.mylectionlearn.data.mapper.Mapper

data class PostServerModel(
    private val id: Int,
    private val title: String,
    private val body: String
) {

    fun <T> map (mapper: Mapper<T>): T
        = mapper.map(id, title, body)
}