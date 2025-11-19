package com.example.hellokotlin.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.hellokotlin.viewModel.HomeViewModel
import com.example.hellokotlin.components.AddInvestmentButton
import com.example.hellokotlin.components.AppFooter
import com.example.hellokotlin.components.AppHeader
import com.example.hellokotlin.components.InvestimentHero

@Composable
fun HomeScreen(
    onNavigateToWalletConfig: () -> Unit,
    homeViewModel: HomeViewModel
) {
    val wallet = homeViewModel.walletConfig.value
    val totalInvestido = wallet?.initialAmount ?: 0.0

    Column {

        AppHeader("Minha carteira")

        InvestimentHero(totalValue = totalInvestido)

        AddInvestmentButton {
            onNavigateToWalletConfig()
        }

        Spacer(modifier = Modifier.height(12.dp))

        AppFooter()
    }
}

