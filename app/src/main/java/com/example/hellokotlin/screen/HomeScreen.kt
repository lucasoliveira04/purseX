package com.example.hellokotlin.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.hellokotlin.components.AddInvestmentButton
import com.example.hellokotlin.components.AppFooter
import com.example.hellokotlin.components.AppHeader
import com.example.hellokotlin.components.InvestimentHero
import com.example.hellokotlin.components.InvestmentItem

@Composable
fun HomeScreen() {
    Column(modifier = Modifier) {

        AppHeader("Minha carteira")

        InvestimentHero(totalValue = 1000.90)

        Column(modifier = Modifier.weight(1f)) {
            InvestmentItem("Tesouro Selic", 4500.00)
            InvestmentItem("CDB Banco XP", 3000.00)
            InvestmentItem("Fundos Imobiliários", 5000.75)
        }

        AddInvestmentButton { }

        Spacer(modifier = Modifier.height(12.dp))

        AppFooter()
    }
}
