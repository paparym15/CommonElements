package com.one.testnotifications.repositories

import com.one.testnotifications.datasources.LocalDataSource
import com.one.testnotifications.datasources.RemoteDataSource
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource): UserRepository {

        override suspend fun callAndStore() {
            remoteDataSource.remoteCall()
            localDataSource.storeLocally()
        }
}