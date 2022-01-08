package com.one.testnotifications.domain.usecases

import com.one.testnotifications.domain.repository.UserRepository
import javax.inject.Inject

class SendUserUseCase @Inject constructor(private val userRepository: UserRepository) {

    fun execute(): Boolean {
        return userRepository.saveUser()
    }
}