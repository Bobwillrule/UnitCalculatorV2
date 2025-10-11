package com.example.unitcalculatorv2.model

import java.util.Stack
import kotlin.math.pow

fun evaluatePostfix(tokens: List<Token>): Double {
    val stack = Stack<Double>()

    for (token in tokens) {
        when (token.type) {
            TokenType.NUMBER -> stack.push(token.value.toDouble())

            TokenType.OPERATOR -> {
                // Pop top two values
                val b = stack.pop()
                val a = stack.pop()

                val result = when (token.value) {
                    "+" -> a + b
                    "-" -> a - b
                    "*" -> a * b
                    "/" -> a / b
                    "^" -> a.pow(b)
                    else -> throw IllegalArgumentException("Unknown operator: ${token.value}")
                }

                stack.push(result)
            }

            else -> throw IllegalArgumentException("Unexpected token type in postfix: ${token.type}")
        }
    }

    if (stack.size != 1) {
        throw IllegalStateException("Invalid postfix expression. Stack: $stack")
    }


    return stack.pop()
}

