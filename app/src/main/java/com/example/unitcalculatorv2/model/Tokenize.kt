package com.example.unitcalculatorv2.model

fun tokenize(expr: String): List<Token> {
    val tokens = mutableListOf<Token>()
    var current = StringBuilder()
    var unit = StringBuilder()
    var exponent = StringBuilder()
    var readingExponent = false

    for (c in expr) {
        when {
            c.isDigit() || c == '.' -> {
                if (readingExponent) exponent.append(c)
                else current.append(c)
            }

            c == '^' -> {
                readingExponent = true
            }

            c in "+-*/" -> {
                if (current.isNotEmpty()) {
                    tokens.add(Token(TokenType.NUMBER, current.toString()))
                    current.clear()
                }
                if (unit.isNotEmpty()) {
                    tokens.add(Token(TokenType.UNIT, unit.toString()))
                    unit.clear()
                }
                if (exponent.isNotEmpty()) {
                    tokens.add(Token(TokenType.OPERATOR, "^"))
                    tokens.add(Token(TokenType.NUMBER, exponent.toString()))
                    exponent.clear()
                }
                tokens.add(Token(TokenType.OPERATOR, c.toString()))
                readingExponent = false
            }

            c == '(' || c == ')' -> {
                if (current.isNotEmpty()) {
                    tokens.add(Token(TokenType.NUMBER, current.toString()))
                    current.clear()
                }
                if (unit.isNotEmpty()) {
                    tokens.add(Token(TokenType.UNIT, unit.toString()))
                    unit.clear()
                }
                tokens.add(
                    if (c == '(') Token(TokenType.LPAREN, "(")
                    else Token(TokenType.RPAREN, ")")
                )
                readingExponent = false
            }

            c.isLetter() -> {
                unit.append(c)
            }

            c.isWhitespace() -> continue
        }
    }

    // flush remaining buffers
    if (current.isNotEmpty()) tokens.add(Token(TokenType.NUMBER, current.toString()))
    if (unit.isNotEmpty()) tokens.add(Token(TokenType.UNIT, unit.toString()))
    if (exponent.isNotEmpty()) {
        tokens.add(Token(TokenType.OPERATOR, "^"))
        tokens.add(Token(TokenType.NUMBER, exponent.toString()))
    }

    return tokens
}
