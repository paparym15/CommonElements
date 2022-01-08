package com.one.testnotifications.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.one.testnotifications.domain.usecases.GetUserUseCase
import com.one.testnotifications.domain.usecases.SendUserUseCase
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(
    private val getUserUseCase: GetUserUseCase,
    private val sendUserNameUseCase: SendUserUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(
            getUserUseCase = getUserUseCase,
            sendUserUseCase = sendUserNameUseCase
        ) as T
    }
}