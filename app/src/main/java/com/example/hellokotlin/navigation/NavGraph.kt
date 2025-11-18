package com.example.hellokotlin.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hellokotlin.data.UserDataStore
import com.example.hellokotlin.screen.HomeScreen
import com.example.hellokotlin.screen.LoginScreen

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()
    val context = LocalContext.current
    val userDataStore = remember { UserDataStore(context) }

    val isLogged by userDataStore.isLogged.collectAsState(initial = false)

    val startDestination = if (isLogged) "home" else "login"

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable("login") {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate("home") {
                        popUpTo("login") { inclusive = true }
                    }
                },
                userDataStore = userDataStore
            )
        }

        composable("home") {
            HomeScreen()
        }
    }
}

