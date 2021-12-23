package com.one.testnotifications.datasources

import javax.inject.Inject

class RemoteDataSource @Inject constructor() {

    fun remoteCall() {
        println("printed: remote call success")
    }
}