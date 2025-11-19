package com.example.hellokotlin.components.stepsConfigWallet.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.hellokotlin.components.stepsConfigWallet.MonthlyContributionStep
import com.example.hellokotlin.viewModel.WalletConfigViewModel
@Composable
fun MonthlyContributionUI(
    step: MonthlyContributionStep,
    viewModel: WalletConfigViewModel
) {
    var text by remember { mutableStateOf("") }

    Column {

        Text(
            "Quanto deseja investir todo mês?",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = text,
            onValueChange = {
                text = it
                val value = it.toDoubleOrNull()
                step.monthlyAmount = value
                viewModel.walletConfig.monthlyAmount = value
            },
            label = { Text("Aporte mensal (R$)") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

