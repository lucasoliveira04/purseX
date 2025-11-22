package com.example.hellokotlin.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.hellokotlin.components.ButtonComponent
import com.example.hellokotlin.components.HeaderComponent
import com.example.hellokotlin.components.SpaceComponent
import com.example.hellokotlin.components.TextFieldComponent
import com.example.hellokotlin.components.TextFieldPasswordComponent
import com.example.hellokotlin.data.UserPreferences
import kotlinx.coroutines.launch


@Composable
fun LoginScreen(
    userPrefs: UserPreferences,
    onLoginClick: () -> Unit = {},
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var error by remember { mutableStateOf("") }

    var scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // HEADER
        HeaderComponent(
            title = "Bem-vindo!",
            subtitle = "Faça login para continuar"
        )

        SpaceComponent(24)

        // CAMPOS
        TextFieldComponent(
            value = email,
            onValueChange = { email = it },
            placeholder = "Email",
            modifier = Modifier.fillMaxWidth()
        )

        SpaceComponent(12)

        TextFieldPasswordComponent(
            value = password,
            onValueChange = { password = it },
            placeholder = "Senha",
            modifier = Modifier.fillMaxWidth()
        )

        SpaceComponent(20)

        // BOTÃO
        ButtonComponent(
            text = "Entrar",
            onClick = {
                scope.launch {
                    userPrefs.getUser().collect { storedUser ->
                        if (email == storedUser.username && password == storedUser.password) {
                            userPrefs.setLoggedIn(true)
                            onLoginClick()
                        } else {
                            error = "Credenciais inválidas"
                        }
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        )

        if (error.isNotEmpty()){
            Text(text=error, color= Color.Red)
        }
    }
}
