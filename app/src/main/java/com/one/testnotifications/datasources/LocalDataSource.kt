package com.one.testnotifications.datasources

import kotlinx.coroutines.delay
import javax.inject.Inject

class LocalDataSource @Inject constructor() {

    suspend fun storeLocally() {
        delay(2000)
        println("printed: stored locally")
    }
}