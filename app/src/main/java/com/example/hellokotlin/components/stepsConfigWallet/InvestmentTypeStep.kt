package com.example.hellokotlin.components.stepsConfigWallet


import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class InvestmentTypeStep(
    selected: String = ""
) : BaseConfigStep() {

    var selectedType by mutableStateOf(selected)

    override val title = "Selecione o tipo de investimento"

    override fun validate(): Boolean {
        return selectedType.isNotEmpty()
    }
}