package com.example.unitcalculatorv2.model

enum class TokenType { NUMBER, OPERATOR, LPAREN, RPAREN, UNIT }

data class Token(
    val type: TokenType,
    val value: String
)

data class UnitValue(
    val unit: Map<String, Int>  // key = base unit, value = exponent
)

val unitMultipliers = mapOf( //dictionary of units
    "mm" to 0.001,
    "cm" to 0.01,
    "m" to 1.0,
    "km" to 1000.0,
    "in" to 0.0254,
    "ft" to 0.3048
)