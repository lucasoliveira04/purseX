package com.example.hellokotlin.components.stepsConfigWallet

class MonthlyContributionStep(
    var monthlyAmount: Double? = null
) : BaseConfigStep() {

    override val title = "Aporte mensal"

    override fun validate(): Boolean {
        return (monthlyAmount ?: 0.0) >= 0.0
    }
}
