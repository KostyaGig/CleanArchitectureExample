package com.admin.mylectionlearn2.data

interface DataSource<R> {
    fun fetchPost(): R
}