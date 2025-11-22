package com.example.hellokotlin.data

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore by preferencesDataStore(name = "user_prefs")
val IS_LOGGED_IN = booleanPreferencesKey("is_logged_in")
class UserPreferences(private val context: Context) {

    companion object {
        val USERNAME = stringPreferencesKey("username")
        val PASSWORD = stringPreferencesKey("password")
        val CREATED_AT = stringPreferencesKey("created_at")
    }

    val isLoggedIn: Flow<Boolean> = context.dataStore.data.map { prefs ->
        prefs[IS_LOGGED_IN] ?: false
    }

    suspend fun setLoggedIn(value: Boolean) {
        context.dataStore.edit { prefs ->
            prefs[IS_LOGGED_IN] = value
        }
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
        context.dataStore.edit { it.clear() }
    }
}