package com.one.testnotifications.di

import com.one.testnotifications.data.datasource.local.UserLocalDataSource
import com.one.testnotifications.data.datasource.remote.UserRemoteDataSource
import com.one.testnotifications.data.repository.UserRepositoryImpl
import com.one.testnotifications.domain.repository.UserRepository
import com.one.testnotifications.domain.usecases.GetUserUseCase
import com.one.testnotifications.domain.usecases.SendUserUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideGetUserUseCase(userRepository: UserRepository): GetUserUseCase {
        return GetUserUseCase(repository = userRepository)
    }

    @Provides
    fun provideSendUserUseCase(userRepository: UserRepository): SendUserUseCase {
        return SendUserUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideUserRepository(
        userLocalDataSource: UserLocalDataSource,
        remoteDataSource: UserRemoteDataSource
    ): UserRepository {
        return UserRepositoryImpl(
            userLocalDataSource,
            remoteDataSource
        )
    }
}