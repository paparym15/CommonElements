package com.one.testnotifications.domain.usecases

import com.one.testnotifications.domain.models.User
import com.one.testnotifications.domain.repository.UserRepository

class GetUserUseCase(private val repository: UserRepository) {

    fun execute(): User {
        return repository.getUser()
    }
}