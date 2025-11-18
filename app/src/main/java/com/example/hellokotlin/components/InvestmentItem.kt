package com.example.hellokotlin.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InvestmentItem(name: String, value: Double) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color(0xFFF3F3F3), shape = MaterialTheme.shapes.small)
            .padding(16.dp)
    ) {
        Text(name, fontSize = 18.sp)
        Text("R$ ${"%.2f".format(value)}", fontSize = 16.sp)
    }
}
