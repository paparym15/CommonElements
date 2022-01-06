package com.one.testnotifications.domain.usecases

import com.one.testnotifications.domain.models.User

class GetUserUseCase {

    fun execute(): User {
        return User("first", "last", 18)
    }
}