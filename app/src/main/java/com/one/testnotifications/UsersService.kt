package com.one.testnotifications

import com.github.javafaker.Faker
import java.util.*

typealias UsersListener = (users: List<User>) -> Unit

object UsersService {

    private var listeners = mutableSetOf<UsersListener>()

    private var users = mutableListOf<User>()

    init {
        val faker = Faker.instance()
        users = (1..100).map {
            User(id = it.toLong(),
                name = faker.name().name(),
                company = faker.company().name(),
                avatar = faker.internet().image()
            )
        }.toMutableList()
    }

    fun getUsers(): List<User> {
        return users
    }

    fun deleteUser(user: User) {
        val indexToDelete = users.indexOfFirst { it.id == user.id }
        if (indexToDelete != -1) {
            users.removeAt(indexToDelete)
            notifyChanges()
        }
    }

    fun moveUser(user: User, moveBy: Int) {
        val oldIndex = users.indexOfFirst { it.id == user.id }
        if (oldIndex == -1) return
        val newIndex = oldIndex + moveBy
        if (newIndex < 0 || newIndex >= users.size) return
        Collections.swap(users, oldIndex, newIndex)
        notifyChanges()
    }

    fun addListener(listener: UsersListener) {
        listeners.add(listener)
        listener.invoke(users)
    }

    fun removeListener(listener: UsersListener) {
        listeners.remove(listener)
    }

    private fun notifyChanges() {
        listeners.forEach { it.invoke(users) }
    }
}