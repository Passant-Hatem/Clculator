package com.example.calculator.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.ui.theme.BACKGROUND
import com.example.calculator.ui.theme.SYMBOL
import com.example.calculator.viewmodel.CalculatorViewModel
import com.example.calculator.viewmodel.CalculatorState
import androidx.compose.material3.Text
import androidx.compose.ui.tooling.preview.Preview
import com.example.calculator.ui.theme.DEL
import com.example.calculator.ui.theme.NUMBER
import com.example.calculator.viewmodel.CalculatorAction
import com.example.calculator.viewmodel.CalculatorOperation

@Composable
fun CalculatorScreen(
     state: CalculatorState,
     viewModel: CalculatorViewModel,
     ){
     Box(modifier = Modifier
          .fillMaxSize()
          .background(color = BACKGROUND)
     ) {
          Column(
               modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter),
               verticalArrangement = Arrangement.spacedBy(8.dp),
          ) {
               Text(
                    text = state.firstNum + (state.operation?.symbol ?: "") + state.secNum,
                    textAlign = TextAlign.End,
                    modifier = Modifier
                         .fillMaxWidth()
                         .padding(vertical = 32.dp),
                    fontWeight = FontWeight.Light,
                    fontSize = 80.sp,
                    color = Color.White,
                    maxLines = 2
               )
               Row(
                    modifier = Modifier
                         .fillMaxWidth()
                         .padding(start = 8.dp ,end = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
               ) {
                    CalculatorButton(
                         symbol = "AC",
                         color = DEL,
                         modifier = Modifier
                              .aspectRatio(2f)
                              .weight(2f)
                    ) {
                         viewModel.onAction(CalculatorAction.Clear)
                    }
                    CalculatorButton(
                         symbol = "Del",
                         color = DEL,
                         modifier = Modifier
                              .aspectRatio(1f)
                              .weight(1f)
                    ) {
                         viewModel.onAction(CalculatorAction.Delete)
                    }
                    CalculatorButton(
                         symbol = "/",
                         color = SYMBOL,
                         modifier = Modifier
                              .aspectRatio(1f)
                              .weight(1f)
                    ) {
                         viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Divide))
                    }
               }
               Row(
                    modifier = Modifier
                         .fillMaxWidth()
                         .padding(start = 8.dp ,end = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
               ) {
                    CalculatorButton(
                         symbol = "7",
                         color = NUMBER,
                         modifier = Modifier
                              .aspectRatio(1f)
                              .weight(1f)
                    ) {
                         viewModel.onAction(CalculatorAction.Number(7))
                    }
                    CalculatorButton(
                         symbol = "8",
                         color = NUMBER,
                         modifier = Modifier
                              .aspectRatio(1f)
                              .weight(1f)
                    ) {
                         viewModel.onAction(CalculatorAction.Number(8))
                    }
                    CalculatorButton(
                         symbol = "9",
                         color = NUMBER,
                         modifier = Modifier
                              .aspectRatio(1f)
                              .weight(1f)
                    ) {
                         viewModel.onAction(CalculatorAction.Number(9))
                    }
                    CalculatorButton(
                         symbol = "x",
                         color = SYMBOL,
                         modifier = Modifier
                              .aspectRatio(1f)
                              .weight(1f)
                    ) {
                         viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Multiply))
                    }
               }
               Row(
                    modifier = Modifier
                         .fillMaxWidth()
                         .padding(start = 8.dp ,end = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
               ) {
                    CalculatorButton(
                         symbol = "4",
                         color = NUMBER,
                         modifier = Modifier
                              .aspectRatio(1f)
                              .weight(1f)
                    ) {
                         viewModel.onAction(CalculatorAction.Number(4))
                    }
                    CalculatorButton(
                         symbol = "5",
                         color = NUMBER,
                         modifier = Modifier
                              .aspectRatio(1f)
                              .weight(1f)
                    ) {
                         viewModel.onAction(CalculatorAction.Number(5))
                    }
                    CalculatorButton(
                         symbol = "6",
                         color = NUMBER,
                         modifier = Modifier
                              .aspectRatio(1f)
                              .weight(1f)
                    ) {
                         viewModel.onAction(CalculatorAction.Number(6))
                    }
                    CalculatorButton(
                         symbol = "-",
                         color = SYMBOL,
                         modifier = Modifier
                              .aspectRatio(1f)
                              .weight(1f)
                    ) {
                         viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Subtract))
                    }
               }
               Row(
                    modifier = Modifier
                         .fillMaxWidth()
                         .padding(start = 8.dp ,end = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
               ) {
                    CalculatorButton(
                         symbol = "1",
                         color = NUMBER,
                         modifier = Modifier
                              .aspectRatio(1f)
                              .weight(1f)
                    ) {
                         viewModel.onAction(CalculatorAction.Number(1))
                    }
                    CalculatorButton(
                         symbol = "2",
                         color = NUMBER,
                         modifier = Modifier
                              .aspectRatio(1f)
                              .weight(1f)
                    ) {
                         viewModel.onAction(CalculatorAction.Number(2))
                    }
                    CalculatorButton(
                         symbol = "3",
                         color = NUMBER,
                         modifier = Modifier
                              .aspectRatio(1f)
                              .weight(1f)
                    ) {
                         viewModel.onAction(CalculatorAction.Number(3))
                    }
                    CalculatorButton(
                         symbol = "+",
                         color = SYMBOL,
                         modifier = Modifier
                              .aspectRatio(1f)
                              .weight(1f)
                    ) {
                         viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Add))
                    }
               }
               Row(
                    modifier = Modifier
                         .fillMaxWidth()
                         .padding(bottom = 8.dp , start = 8.dp ,end = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
               ) {
                    CalculatorButton(
                         symbol = "0",
                         color = NUMBER,
                         modifier = Modifier
                              .aspectRatio(2f)
                              .weight(2f)
                    ) {
                         viewModel.onAction(CalculatorAction.Number(0))
                    }
                    CalculatorButton(
                         symbol = ".",
                         color = NUMBER,
                         modifier = Modifier
                              .aspectRatio(1f)
                              .weight(1f)
                    ) {
                         viewModel.onAction(CalculatorAction.Decimal)
                    }
                    CalculatorButton(
                         symbol = "=",
                         color = SYMBOL,
                         modifier = Modifier
                              .aspectRatio(1f)
                              .weight(1f)
                    ) {
                         viewModel.onAction(CalculatorAction.Calculate)
                    }
               }
          }
     }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
     CalculatorScreen(
          state = CalculatorState(),
          viewModel = CalculatorViewModel()
     )
}