package com.example.unitcalculatorv2.model


fun convertToBaseValue(numStr: String, unit: String): Double {
    if (unit in unitMultipliers) {
        return (numStr.toDoubleOrNull() ?: 0.0) * (unitMultipliers[unit] ?: 1.0) //return original value if fails
    }
    // No unit found, plain number
    return numStr.toDoubleOrNull()?: 0.0
}

//EFFECTS: checks the validity of units. Ie mm^2+mm is not valid
fun validityOfUnits(tokens: List<Token>): Boolean {
    return true //stub
}


fun applyUnits(tokens: List<Token>): List<Token> {
    val result = mutableListOf<Token>()
    var i = 0

    while (i < tokens.size) {
        val token = tokens[i]

        if (token.type == TokenType.NUMBER &&
            i + 1 < tokens.size &&
            tokens[i + 1].type == TokenType.UNIT) {

            val number = token.value.toDoubleOrNull() ?: 0.0
            val unit = tokens[i + 1].value
            val multiplier = unitMultipliers[unit] ?: 1.0
            val converted = number * multiplier

            result.add(Token(TokenType.NUMBER, converted.toString()))
            i += 2 // skip the unit token

        } else {
            result.add(token)
            i++
        }
    }

    return result
}
