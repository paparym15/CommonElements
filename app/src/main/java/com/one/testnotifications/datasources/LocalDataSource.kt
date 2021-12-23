package com.one.testnotifications.datasources

import javax.inject.Inject

class LocalDataSource @Inject constructor() {

    fun storeLocally() {
        println("printed: stored locally")
    }
}