package com.one.testnotifications.di

import com.one.testnotifications.data.datasource.local.UserLocalDataSource
import com.one.testnotifications.data.datasource.local.UserLocalDataSourceImpl
import com.one.testnotifications.data.datasource.remote.UserRemoteDataSource
import com.one.testnotifications.data.datasource.remote.UserRemoteDataSourceImpl
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideUserLocalDataSource(): UserLocalDataSource {
        return UserLocalDataSourceImpl()
    }

    @Provides
    fun provideUserRemoteDataSource(): UserRemoteDataSource {
        return UserRemoteDataSourceImpl()
    }
}