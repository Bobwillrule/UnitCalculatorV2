package com.example.unitcalculatorv2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.unitcalculatorv2.model.ExpressionEvaluator
import com.example.unitcalculatorv2.ui.theme.UnitCalculatorV2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitCalculatorV2Theme {
                CalculatorApp() // from CalculatorScreen.kt
            }
        }
    }
}

@Composable
fun CalculatorApp() {
        CalculatorScreen()
    }
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val expr = "3cm + 4mm * 2cat / (1tree - 5not)^2"
    val result = ExpressionEvaluator.evaluate(expr)

    Text(
        text = "Expression: $expr\nResult: $result",
        modifier = modifier
    )
}
