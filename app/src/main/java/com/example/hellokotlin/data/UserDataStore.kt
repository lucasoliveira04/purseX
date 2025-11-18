package com.example.hellokotlin.data

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore by preferencesDataStore(name = "user_prefs")

class UserDataStore(private val context: Context) {

    private val LOGIN_KEY = booleanPreferencesKey("is_logged")

    val isLogged: Flow<Boolean> = context.dataStore.data.map { prefs ->
        prefs[LOGIN_KEY] ?: false
    }

    suspend fun saveLoginState(logged: Boolean) {
        context.dataStore.edit { prefs ->
            prefs[LOGIN_KEY] = logged
        }
    }
}