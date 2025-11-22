package com.example.hellokotlin.nav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hellokotlin.screen.HomeScreen
import com.example.hellokotlin.screen.LoginScreen

@Composable
fun AppNavGraph(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ) {
        composable(Screen.Login.route) {
            LoginScreen();
        }

        composable(Screen.Home.route) {
            HomeScreen()
        }
    }
}