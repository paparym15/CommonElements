package com.one.testnotifications.datasources

import kotlinx.coroutines.delay
import javax.inject.Inject

class RemoteDataSource @Inject constructor() {

    suspend fun remoteCall() {
        delay(4000)
        println("printed: remote call success")
    }
}