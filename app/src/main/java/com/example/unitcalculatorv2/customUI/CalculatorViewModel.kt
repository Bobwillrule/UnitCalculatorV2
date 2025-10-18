package com.example.unitcalculatorv2.customUI

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.unitcalculatorv2.model.ExpressionEvaluator

class CalculatorViewModel : ViewModel() {
    var expression by mutableStateOf("")
        private set
    var result by mutableStateOf("")
        private set

    fun onButtonClick(label: String) {
        when (label) {
            "=" -> result = (ExpressionEvaluator.evaluate(expression)).toString()
            "AC" -> {
                expression = ""
                result = ""
            }
            "⌫" -> if (expression.isNotEmpty()) expression = expression.dropLast(1)
            else -> expression += label
        }
    }
}
