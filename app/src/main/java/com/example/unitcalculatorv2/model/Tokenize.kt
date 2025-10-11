package com.example.unitcalculatorv2.model

fun tokenize(expr: String): List<Token> {
    val tokens = mutableListOf<Token>()
    var current = ""

    for (c in expr) {
        when {
            c.isDigit() || c == '.' -> {
                current += c
            }

            c in "+-*/^" -> {
                if (current.isNotEmpty()) {
                    tokens.add(Token(TokenType.NUMBER, current))
                    current = ""
                }
                tokens.add(Token(TokenType.OPERATOR, c.toString()))
            }

            c == '(' || c == ')' -> {
                // Flush current number before parenthesis
                if (current.isNotEmpty()) {
                    tokens.add(Token(TokenType.NUMBER, current))
                    current = ""
                }

                tokens.add(
                    if (c == '(') Token(TokenType.LPAREN, "(")
                    else Token(TokenType.RPAREN, ")")
                )
            }

            c.isWhitespace() -> continue
        }
    }

    // Add last number if any
    if (current.isNotEmpty()) tokens.add(Token(TokenType.NUMBER, current))

    return tokens
}
