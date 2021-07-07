package com.admin.mylectionlearn.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.admin.mylectionlearn.presentation.model.PostUiModel

interface Communication {
    fun show(data: Triple<Int,String,String>)
    fun observe(owner: LifecycleOwner, observer: Observer<Triple<Int, String, String>>)

    class BaseCommunication(): Communication {

        private val _liveData = MutableLiveData<Triple<Int, String, String>>()
        private val liveData: LiveData<Triple<Int, String, String>> = _liveData

        override fun show(data: Triple<Int, String, String>) {
            _liveData.value = data
        }

        override fun observe(
            owner: LifecycleOwner,
            observer: Observer<Triple<Int, String, String>>
        ) {
            liveData.observe(owner,observer)
        }
    }
}