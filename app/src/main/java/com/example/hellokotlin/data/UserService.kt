package com.example.hellokotlin.data

import android.content.Context
import kotlinx.coroutines.flow.Flow
import java.time.LocalDateTime

class UserService(context: Context) {
    private val prefs = UserPreferences(context)

    suspend fun registerUser(username: String, password: String) {
        val createdAt = LocalDateTime.now().toString()
        prefs.saveUser(username, password, createdAt)
    }

    fun getUser(): Flow<UserData> {
        return prefs.getUser()
    }

    suspend fun logout() {
        prefs.clear()
    }
}