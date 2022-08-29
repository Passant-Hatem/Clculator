package com.example.calculator.viewmodel

sealed class CalculatorAction{
    data class Number(val number: Int): CalculatorAction()
    data class Operation(val operation: CalculatorOperation): CalculatorAction()
    object Clear: CalculatorAction()
    object Delete: CalculatorAction()
    object Calculate: CalculatorAction()
    object Decimal: CalculatorAction()
}
