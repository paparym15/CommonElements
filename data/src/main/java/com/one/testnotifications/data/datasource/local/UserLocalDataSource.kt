package com.one.testnotifications.data.datasource.local

import com.one.testnotifications.data.models.UserDTO

interface UserLocalDataSource {

    fun getData(): UserDTO
}