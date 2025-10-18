package com.example.unitcalculatorv2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unitcalculatorv2.customUI.CalculatorButtons
import com.example.unitcalculatorv2.model.ExpressionEvaluator

@Composable
fun CalculatorScreen() {
    var input by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    fun onButtonClick(value: String) {
        when (value) {
            "AC" -> {
                input = ""
                result = ""
            }
            "⌫" -> if (input.isNotEmpty()) input = input.dropLast(1)
            "=" -> {
            try {
                val evalResult = ExpressionEvaluator.evaluate(input)// returns a Double
                result = "= $evalResult"
            } catch (e: Exception) {
                result = "Error"
            }
        }
            else -> input += value
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1E1E1E))
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // Display section
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = input,
                color = Color.White,
                fontSize = 32.sp,
                textAlign = TextAlign.End,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = result,
                color = Color(0xFFB0B0B0),
                fontSize = 24.sp,
                textAlign = TextAlign.End,
                modifier = Modifier.fillMaxWidth()
            )
        }

        // Button grid
        CalculatorButtons(onButtonClick = ::onButtonClick)
    }
}
