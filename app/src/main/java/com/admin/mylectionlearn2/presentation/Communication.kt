package com.admin.mylectionlearn2.presentation

import com.admin.mylectionlearn.presentation.model.PostUiModel

interface Communication {
    fun show(postUiModel: PostUiModel)
}