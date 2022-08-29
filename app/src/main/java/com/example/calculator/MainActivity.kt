package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.calculator.screens.CalculatorScreen
import com.example.calculator.viewmodel.CalculatorViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = viewModel<CalculatorViewModel>()
            val state = viewModel.state
            CalculatorScreen(
                state = state,
                viewModel = viewModel
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

}