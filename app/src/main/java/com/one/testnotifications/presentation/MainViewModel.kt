package com.one.testnotifications.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.one.testnotifications.domain.models.User
import com.one.testnotifications.domain.usecases.GetUserUseCase
import com.one.testnotifications.domain.usecases.SendUserUseCase

class MainViewModel(
    private val getUserUseCase: GetUserUseCase,
    private val sendUserUseCase: SendUserUseCase
): ViewModel() {

    val userLD = MutableLiveData<User>()

    val sendingStatus = MutableLiveData<Boolean>()

    fun getUser() {
        userLD.value = getUserUseCase.execute()
    }

    fun sendUser() {
        sendingStatus.value = sendUserUseCase.execute()
    }
}