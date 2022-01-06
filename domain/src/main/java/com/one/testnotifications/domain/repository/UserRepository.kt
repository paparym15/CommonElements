package com.one.testnotifications.domain.repository

import com.one.testnotifications.domain.models.User

interface UserRepository {

    fun getUser(): User

    fun saveUser(): Boolean
}