package com.one.testnotifications.data.repository

import com.one.testnotifications.data.datasource.local.UserLocalDataSource
import com.one.testnotifications.data.datasource.remote.UserRemoteDataSource
import com.one.testnotifications.domain.models.User
import com.one.testnotifications.domain.repository.UserRepository

class UserRepositoryImpl (
    private val localDataSource: UserLocalDataSource,
    private val remoteDataSource: UserRemoteDataSource
): UserRepository {

    override fun getUser(): User {
        val userDto = localDataSource.getData()
        return User(userDto.firstName, userDto.lastName, userDto.age)
    }

    override fun saveUser(): Boolean {
        return remoteDataSource.sendData()
    }
}