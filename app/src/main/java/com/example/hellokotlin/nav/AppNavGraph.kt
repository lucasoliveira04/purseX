package com.example.hellokotlin.nav

import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hellokotlin.data.UserPreferences
import com.example.hellokotlin.screen.HomeScreen
import com.example.hellokotlin.screen.LoginScreen
import com.example.hellokotlin.screen.LoadingScreen
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

@Composable
fun AppNavGraph(userPrefs: UserPreferences) {

    val navController = rememberNavController()
    var startDestination by remember { mutableStateOf("loading") }

    // Carrega o estado do login ANTES de navegar
    LaunchedEffect(Unit) {
        val isLoggedIn = userPrefs.isLoggedIn.first()
        startDestination = if (isLoggedIn) "home" else "login"
        navController.navigate(startDestination) {
            popUpTo("loading") { inclusive = true }
        }
    }

    NavHost(
        navController = navController,
        startDestination = "loading"
    ) {
        composable("loading") { LoadingScreen() }

        composable("login") {
            LoginScreen(
                userPrefs = userPrefs,
                onLoginClick = {
                    navController.navigate("home") {
                        popUpTo("login") { inclusive = true }
                    }
                }
            )
        }

        composable("home") {
            HomeScreen()
        }
    }
}
