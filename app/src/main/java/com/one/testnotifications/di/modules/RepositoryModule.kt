package com.one.testnotifications.di.modules

import com.one.testnotifications.repositories.UserRepository
import com.one.testnotifications.repositories.UserRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {

    @Binds
    fun bindsUserRepository(userRepository: UserRepositoryImpl): UserRepository
}