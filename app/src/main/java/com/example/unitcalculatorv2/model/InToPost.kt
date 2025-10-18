package com.example.unitcalculatorv2.model

import java.util.Stack

fun prec(c: Char): Int {
    return when (c) {
        '^' -> 3
        '*', '/' -> 2
        '+', '-' -> 1
        else -> -1
    }
}

fun isRightAssociative(c: Char): Boolean {
    return c == '^'
}


fun InToPost(tokens: List<Token>): List<Token> {
    val output = mutableListOf<Token>()
    val stack = Stack<Token>()

    for (token in tokens) {
        when (token.type) {
            TokenType.NUMBER -> output.add(token)

            TokenType.OPERATOR -> {
                while (stack.isNotEmpty() && stack.peek().type == TokenType.OPERATOR) {
                    val top = stack.peek()
                    val topPrec = prec(top.value[0])
                    val currPrec = prec(token.value[0])
                    val rightAssoc = isRightAssociative(token.value[0])

                    if (topPrec > currPrec || (topPrec == currPrec && !rightAssoc)) {
                        output.add(stack.pop())
                    } else {
                        break
                    }
                }
                stack.push(token)
            }

            TokenType.LPAREN -> stack.push(token)

            TokenType.RPAREN -> {
                while (stack.isNotEmpty() && stack.peek().type != TokenType.LPAREN) {
                    output.add(stack.pop())
                }
                if (stack.isNotEmpty() && stack.peek().type == TokenType.LPAREN) {
                    stack.pop()
                }
            }
            TokenType.UNIT -> continue
        }
    }

    while (stack.isNotEmpty()) {
        output.add(stack.pop())
    }

    return output
}
