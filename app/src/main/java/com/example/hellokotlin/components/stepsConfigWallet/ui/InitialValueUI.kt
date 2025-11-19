package com.example.hellokotlin.components.stepsConfigWallet.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.hellokotlin.components.stepsConfigWallet.InitialValueStep
import com.example.hellokotlin.viewModel.WalletConfigViewModel

@Composable
fun InitialValueUI(
    step: InitialValueStep,
    viewModel: WalletConfigViewModel
) {
    var text by remember { mutableStateOf("") }

    Column {

        Text(
            "Quanto você já possui?",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = text,
            onValueChange = {
                text = it
                val value = it.toDoubleOrNull()
                step.initialAmount = value
                viewModel.walletConfig.initialAmount = value
            },
            label = { Text("Valor inicial (R$)") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

