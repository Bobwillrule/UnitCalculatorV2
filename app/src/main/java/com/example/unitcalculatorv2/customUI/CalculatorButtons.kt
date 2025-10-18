package com.example.unitcalculatorv2.customUI

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CalculatorButtons(onButtonClick: (String) -> Unit) {
    val buttons = listOf(
        listOf("AC", "⌫", "(", ")"),
        listOf("7", "8", "9", "÷"),
        listOf("4", "5", "6", "×"),
        listOf("1", "2", "3", "-"),
        listOf("0", ".", "=", "+")
    )

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        buttons.forEach { row ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                row.forEach { label ->
                    Button(
                        onClick = { onButtonClick(label) },
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (label in listOf("+", "-", "×", "÷", "="))
                                Color(0xFFFF9800) else Color(0xFF2D2D2D),
                            contentColor = Color.White
                        )
                    ) {
                        Text(text = label, fontSize = 24.sp)
                    }
                }
            }
        }
    }
}
