package com.admin.mylectionlearn2.presentation.model

import com.admin.mylectionlearn2.presentation.Communication
import com.admin.mylectionlearn2.core.Abstract

sealed class PostUiModel : Abstract.Object<Unit,Abstract.Mapper.Empty>() {

    abstract fun show()

    class Success(
        private val id: Int,
        private val title: String,
        private val body: String,
        private val communication: Communication
    ): PostUiModel() {
        override fun show() {
            communication.show(Triple(id,title,body))
        }

        override fun map(mapper: Abstract.Mapper.Empty) = Unit
    }

    class Failure(
        private val errorMessage: String,
        private val communication: Communication
    ): PostUiModel() {
        override fun show() {
            communication.show(Triple(0,errorMessage,""))
        }

        override fun map(mapper: Abstract.Mapper.Empty) = Unit
    }
}
