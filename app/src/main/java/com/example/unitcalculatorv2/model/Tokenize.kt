package com.example.unitcalculatorv2.model

fun tokenize(expr: String): List<Token> {
    val tokens = mutableListOf<Token>()
    var current = ""
    for (c in expr) {
        when {
            c.isDigit() || c == '.' -> current += c // create a number
            c in "+-*/^" -> {
                if (current.isNotEmpty()) { //Found a operator, also put the number in front in
                    tokens.add(Token(TokenType.NUMBER, current))
                    current = ""
                }
                tokens.add(Token(TokenType.OPERATOR, c.toString()))
            }
            c == '(' -> tokens.add(Token(TokenType.LPAREN, "("))
            c == ')' -> tokens.add(Token(TokenType.RPAREN, ")"))
            c.isWhitespace() -> continue
        }
    }
    if (current.isNotEmpty()) tokens.add(Token(TokenType.NUMBER, current)) //The last number
    return tokens
}