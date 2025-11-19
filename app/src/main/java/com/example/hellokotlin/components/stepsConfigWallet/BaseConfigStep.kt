package com.example.hellokotlin.components.stepsConfigWallet

abstract class BaseConfigStep {

    abstract val title: String

    open fun validate(): Boolean = true

    open fun onConfirm() {}
}