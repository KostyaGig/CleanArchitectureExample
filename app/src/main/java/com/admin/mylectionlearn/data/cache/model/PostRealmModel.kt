package com.admin.mylectionlearn.data.cache.model

import com.admin.mylectionlearn.data.mapper.Mapper

// TODO: 06.07.2021 this class should extends on RealmObject
class PostRealmModel {
    var id: Int = 0
    var title: String = ""
    var body: String = ""

    fun <T> map (mapper: Mapper<T>): T = mapper.map(id,title, body)
}