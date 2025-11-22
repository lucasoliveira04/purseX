package com.example.hellokotlin.nav

sealed class Screen
    (val route: String)
{
    object Login : Screen("login")
    object Home : Screen("home")
}