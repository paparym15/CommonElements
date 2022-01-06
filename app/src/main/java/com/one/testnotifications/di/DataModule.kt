package com.one.testnotifications.di

import com.one.testnotifications.data.datasource.local.UserLocalDataSource
import com.one.testnotifications.data.datasource.local.UserLocalDataSourceImpl
import com.one.testnotifications.data.datasource.remote.UserRemoteDataSource
import com.one.testnotifications.data.datasource.remote.UserRemoteDataSourceImpl
import com.one.testnotifications.data.repository.UserRepositoryImpl
import com.one.testnotifications.domain.repository.UserRepository
import org.koin.dsl.module

val dataModule = module {

    single<UserRepository> { UserRepositoryImpl(get(), get()) }

    single<UserLocalDataSource> { UserLocalDataSourceImpl() }
    single<UserRemoteDataSource> { UserRemoteDataSourceImpl() }
}