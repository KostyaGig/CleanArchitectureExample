package com.admin.mylectionlearn.data.model

import com.admin.mylectionlearn.data.mapper.Mapper

data class PostDataModel(
    private val id: Int,
    private val title: String,
    private val body: String
) {

    fun <T> map(mapper: Mapper<T>): T = mapper.map(id, title, body)
}