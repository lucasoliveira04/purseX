package com.example.hellokotlin.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.hellokotlin.components.ButtonComponent
import com.example.hellokotlin.components.FooterComponent
import com.example.hellokotlin.components.HeaderComponent
import com.example.hellokotlin.components.SpaceComponent
import com.example.hellokotlin.components.TextFieldComponent
import com.example.hellokotlin.components.TextFieldPasswordComponent


@Composable
fun LoginScreen(
    onLoginClick: () -> Unit = {},
    onRegisterClick: () -> Unit = {}
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

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
            onClick = onLoginClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        )

        // FOOTER
        FooterComponent(
            text = "Não tem conta? Criar conta",
            onRegisterClick = onRegisterClick
        )
    }
}
