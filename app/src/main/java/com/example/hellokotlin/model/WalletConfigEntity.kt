package com.example.hellokotlin.model

data class WalletConfig(
    var type: String = "",
    var initialAmount: Double? = null,
    var monthlyAmount: Double? = null
)