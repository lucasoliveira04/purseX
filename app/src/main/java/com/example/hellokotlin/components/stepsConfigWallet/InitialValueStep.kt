package com.example.hellokotlin.components.stepsConfigWallet

class InitialValueStep(
    var initialAmount: Double? = null
) : BaseConfigStep() {

    override val title = "Valor inicial investido"

    override fun validate(): Boolean {
        return (initialAmount ?: 0.0) > 0.0
    }
}
