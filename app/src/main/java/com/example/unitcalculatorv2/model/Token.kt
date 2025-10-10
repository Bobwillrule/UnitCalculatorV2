package com.example.unitcalculatorv2.model

enum class TokenType { NUMBER, OPERATOR, LPAREN, RPAREN }

data class Token(
    val type: TokenType,
    val value: String
)