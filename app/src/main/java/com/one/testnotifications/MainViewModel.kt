package com.one.testnotifications

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    val textOneLD = MutableLiveData<String>()
    val updateTextOneEvent = MutableLiveData<Unit>()

    init {

    }

    fun updateTextOneLD(status: String) {
        textOneLD.value = status
    }
}