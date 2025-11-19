package com.example.hellokotlin.components.stepsConfigWallet.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.hellokotlin.components.stepsConfigWallet.InvestmentTypeStep
import com.example.hellokotlin.viewModel.WalletConfigViewModel

@Composable
fun InvestmentTypeUI(
    step: InvestmentTypeStep,
    viewModel: WalletConfigViewModel
) {
    Column {

        Text(
            "Escolha o tipo:",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        val options = listOf("Tesouro Selic", "CDB", "FIIs", "Ações")

        options.forEach { type ->
            ElevatedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp)
                    .clickable {
                        step.selectedType = type
                        viewModel.walletConfig.type = type
                    },
                colors = CardDefaults.elevatedCardColors(
                    containerColor = if (step.selectedType == type)
                        MaterialTheme.colorScheme.primaryContainer
                    else
                        MaterialTheme.colorScheme.surface
                )
            ) {
                Row(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = type,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }
}
