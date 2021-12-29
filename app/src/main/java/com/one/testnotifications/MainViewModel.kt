package com.one.testnotifications

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.one.testnotifications.repositories.UserRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {

    init {
        initialCall()
    }

     private fun initialCall() {
        viewModelScope.launch {
            userRepository.callAndStore()
        }
    }
}