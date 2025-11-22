package com.example.hellokotlin.data

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserPreferences
    (private val context: Context)
{
    private val Context.dataStore by preferencesDataStore(name = "user_prefs")

    companion object {
        val USERNAME = stringPreferencesKey("username")
        val PASSWORD = stringPreferencesKey("password")
        val CREATED_AT = stringPreferencesKey("created_at")
    }

    suspend fun saveUser(username: String, password: String, createdAt: String) {
        context.dataStore.edit { prefs ->
            prefs[USERNAME] = username
            prefs[PASSWORD] = password
            prefs[CREATED_AT] = createdAt
        }
    }

    fun getUser(): Flow<UserData> =
        context.dataStore.data.map { prefs ->
            UserData().apply {
                username = prefs[USERNAME] ?: ""
                password = prefs[PASSWORD] ?: ""
                createdAt = prefs[CREATED_AT] ?: ""
            }
        }

    suspend fun clear() {
        context.dataStore.edit {
            it.clear()
        }
    }
}