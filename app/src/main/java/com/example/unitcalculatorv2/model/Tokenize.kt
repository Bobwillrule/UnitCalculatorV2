package com.example.unitcalculatorv2.model

val unitMultipliers = mapOf( //dictionary of units
    "mm" to 0.001,
    "cm" to 0.01,
    "m" to 1.0,
    "km" to 1000.0,
    "in" to 0.0254,
    "ft" to 0.3048
)

fun convertToBaseValue(numStr: String, unit: String): Double {
    if (unit in unitMultipliers) {
        return (numStr.toDoubleOrNull() ?: 0.0) * (unitMultipliers[unit] ?: 1.0) //return original value if fails
    }
    // No unit found, plain number
    return numStr.toDoubleOrNull()?: 0.0
}

fun tokenize(expr: String): List<Token> {
    val tokens = mutableListOf<Token>()
    var current = ""
    val unit = StringBuilder();

    for (c in expr) {
        when {
            c.isDigit() || c == '.' -> { // collect the digits
                current += c
            }

            c in "+-*/^" -> {
                if (current.isNotEmpty()) { // if encounter operator add prev num ie 34+

                    tokens.add(Token(TokenType.NUMBER, current))
                    current = ""
                }
                tokens.add(Token(TokenType.OPERATOR, c.toString()))
            }

            c == '(' || c == ')' -> {
                // Flush current number before parenthesis
                if (current.isNotEmpty()) { // flushes +3)
                    tokens.add(Token(TokenType.NUMBER, current))
                    current = ""
                }
                tokens.add(
                    if (c == '(') Token(TokenType.LPAREN, "(")
                    else Token(TokenType.RPAREN, ")")
                )
            }

            c.isLetter() ->{
                unit.append(c) //Collect the units
            }

            c.isWhitespace() -> continue
        }
    }

    // Add last number if any
    if (current.isNotEmpty()) tokens.add(Token(TokenType.NUMBER, current))

    return tokens
}
