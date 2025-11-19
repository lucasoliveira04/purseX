package com.example.hellokotlin.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.hellokotlin.model.WalletConfig

class HomeViewModel : ViewModel() {
    var walletConfig = mutableStateOf<WalletConfig?>(null)
        private set

    fun updateWalletConfig(config: WalletConfig) {
        walletConfig.value = config
    }
}