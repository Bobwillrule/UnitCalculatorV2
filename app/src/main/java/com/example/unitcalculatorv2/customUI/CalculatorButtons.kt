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
fun CalculatorButtons(
    buttons: List<List<String>>,
    toggleButton: String,
    onButtonClick: (String) -> Unit
) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        // All rows except toggle
        buttons.forEach { row ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                row.forEach { label ->
                    if (label.isNotEmpty()) {
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
                    } else {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
        }

        // Toggle button row at the bottom
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { onButtonClick(toggleButton) },
                modifier = Modifier
                    .fillMaxWidth()           // full width minus padding
                    .height(64.dp)            // same height as other buttons
                    .padding(horizontal = 4.dp), // small left/right margin
                shape = androidx.compose.foundation.shape.RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFF9800),
                    contentColor = Color.White
                )
            ) {
                Text(text = toggleButton, fontSize = 24.sp)
            }
        }
    }
}
