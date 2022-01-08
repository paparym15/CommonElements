package com.one.testnotifications.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.one.testnotifications.domain.models.User
import com.one.testnotifications.domain.usecases.GetUserUseCase
import com.one.testnotifications.domain.usecases.SendUserUseCase

class MainViewModel(
    private val getUserUseCase: GetUserUseCase,
    private val sendUserUseCase: SendUserUseCase
): ViewModel() {

    init {
        Log.d("-->", "vm created")
    }

    val userLD = MutableLiveData<User>()
    val resultLD = MutableLiveData<Boolean>()

    fun getData() {
        userLD.value = getUserUseCase.execute()
    }

    fun sendData() {
        resultLD.value = sendUserUseCase.execute()
    }

    override fun onCleared() {
        Log.d("-->", "vm killed")
        super.onCleared()
    }
}