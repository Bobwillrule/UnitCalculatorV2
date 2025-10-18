package com.example.unitcalculatorv2.model


object ExpressionEvaluator {

    fun evaluate(expr: String): Double {
        // Step 1: Tokenize
        val tokens = tokenize(expr);

        val cleanedUp = applyUnits(tokens); //in the unit handler file

        // Step 2: Convert to postfix
        val postfix = InToPost(cleanedUp);

        // Step 3: Evaluate postfix
        return evaluatePostfix(postfix);
    }
}