package com.example.calculator.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculatorViewModel: ViewModel() {

    var state by mutableStateOf(CalculatorState())
        private set

    fun onAction(action: CalculatorAction) {
        when(action) {
            is CalculatorAction.Number -> enterNumber(action.number)
            is CalculatorAction.Delete -> delete()
            is CalculatorAction.Clear -> state = CalculatorState()
            is CalculatorAction.Operation -> enterOperation(action.operation)
            is CalculatorAction.Decimal -> enterDecimal()
            is CalculatorAction.Calculate -> calculate()
        }
    }

    private fun enterOperation(operation: CalculatorOperation) {
        if(state.firstNum.isNotBlank()) {
            state = state.copy(operation = operation)
        }
    }

    private fun calculate() {
        val firstNum = state.firstNum.toDoubleOrNull()
        val secNum = state.secNum.toDoubleOrNull()
        if(firstNum != null && secNum != null) {
            val result = when(state.operation) {
                is CalculatorOperation.Add -> firstNum + secNum
                is CalculatorOperation.Subtract -> firstNum - secNum
                is CalculatorOperation.Multiply -> firstNum * secNum
                is CalculatorOperation.Divide -> firstNum / secNum
                null -> return
            }
            state = state.copy(
                firstNum = result.toString().take(15),
                secNum = "",
                operation = null
            )
        }
    }

    private fun delete() {
        when {
            state.secNum.isNotBlank() -> state = state.copy(
                secNum = state.secNum.dropLast(1)
            )
            state.operation != null -> state = state.copy(
                operation = null
            )
            state.firstNum.isNotBlank() -> state = state.copy(
                firstNum = state.firstNum.dropLast(1)
            )
        }
    }

    private fun enterDecimal() {
        if(state.operation == null && !state.firstNum.contains(".") && state.firstNum.isNotBlank()) {
            state = state.copy(
                firstNum = state.firstNum + "."
            )
            return
        } else if(!state.secNum.contains(".") && state.secNum.isNotBlank()) {
            state = state.copy(
                secNum = state.secNum + "."
            )
        }
    }

    private fun enterNumber(number: Int) {
        if(state.operation == null) {
            if(state.firstNum.length >= MAX_NUM_LENGTH) {
                return
            }
            state = state.copy(
                firstNum = state.firstNum + number
            )
            return
        }
        if(state.secNum.length >= MAX_NUM_LENGTH) {
            return
        }
        state = state.copy(
            secNum = state.secNum + number
        )
    }

    companion object {
        private const val MAX_NUM_LENGTH = 8
    }
}