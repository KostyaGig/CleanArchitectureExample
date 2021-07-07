package com.admin.mylectionlearn.data

interface DataSource<R> {
    suspend fun fetchPost(): R
}