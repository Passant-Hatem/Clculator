package com.example.calculator.viewmodel

data class CalculatorState(
    val firstNum: String = "",
    val secNum: String = "",
    val operation: CalculatorOperation? = null
)
