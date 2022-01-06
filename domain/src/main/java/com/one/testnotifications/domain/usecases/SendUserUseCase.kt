package com.one.testnotifications.domain.usecases

import com.one.testnotifications.domain.repository.UserRepository

class SendUserUseCase(private val userRepository: UserRepository) {

    fun execute(): Boolean {
        return userRepository.saveUser()
    }
}