package com.example.hellokotlin.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.hellokotlin.components.stepsConfigWallet.BaseConfigStep
import com.example.hellokotlin.components.stepsConfigWallet.InitialValueStep
import com.example.hellokotlin.components.stepsConfigWallet.InvestmentTypeStep
import com.example.hellokotlin.components.stepsConfigWallet.MonthlyContributionStep
import com.example.hellokotlin.model.WalletConfig

class WalletConfigViewModel : ViewModel() {

    // final object building
    var walletConfig = WalletConfig()
        public set

    // management steps
    private val steps: List<BaseConfigStep> = listOf(
        InvestmentTypeStep(),
        InitialValueStep(),
        MonthlyContributionStep()
    )

    var currentStepIndex by mutableStateOf(0)
        private set

    val currentStep: BaseConfigStep
        get() = steps[currentStepIndex]

    fun nextStep() {
        if (currentStep.validate() && currentStepIndex < steps.size - 1) {
            currentStepIndex++
        }
    }

    fun previousStep() {
        if (currentStepIndex > 0) {
            currentStepIndex--
        }
    }

    fun isLastStep() = currentStepIndex == steps.size - 1
}
