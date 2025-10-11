package com.example.unitcalculatorv2.model


object ExpressionEvaluator {

    fun evaluate(expr: String): Double {
        // Step 1: Tokenize
        val tokens = tokenize(expr);

        // Step 2: Convert to postfix
        val postfix = InToPost(tokens);

        // Step 3: Evaluate postfix
        return evaluatePostfix(postfix);
    }
}