package com.one.testnotifications.data.datasource.local

import com.one.testnotifications.data.models.UserDTO

class UserLocalDataSourceImpl: UserLocalDataSource {
    override fun getData(): UserDTO {
        return UserDTO("Frank", "Capra", 44)
    }
}