package com.example.hellokotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.hellokotlin.data.UserPreferences
import com.example.hellokotlin.nav.AppNavGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val userPrefs = UserPreferences(this)

        setContent {
            AppNavGraph(userPrefs)
        }
    }
}
