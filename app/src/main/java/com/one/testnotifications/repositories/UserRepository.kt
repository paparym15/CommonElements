package com.one.testnotifications.repositories

interface UserRepository {

    suspend fun callAndStore()
}