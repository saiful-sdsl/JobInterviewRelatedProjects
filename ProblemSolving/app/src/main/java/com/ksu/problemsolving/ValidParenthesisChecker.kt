package com.ksu.problemsolving

import java.util.*

class ValidParenthesisChecker(private val givenString: Array<String>) {

    fun checkIfValid(): ArrayList<Boolean> {
        val validationCheckArray = arrayListOf<Boolean>()
        for (aStringForValidationCheck in givenString) {
            validationCheckArray.add(getValidationCheckStatusFor(aStringForValidationCheck))
        }
        return validationCheckArray
    }

    private fun getValidationCheckStatusFor(aStringForValidationCheck: String): Boolean {
        val startingParenthesisStack = Stack<Char>()

        if (aStringForValidationCheck.length % 2 != 0) return false

        for (checkingChar in aStringForValidationCheck) {
            when (checkingChar) {
                '(', '{', '[' -> startingParenthesisStack.push(checkingChar)
                '}' -> {
                    if (startingParenthesisStack.isEmpty() || startingParenthesisStack.pop() != '{') {
                        return false
                    }
                }
                ']' -> {
                    if (startingParenthesisStack.isEmpty() || startingParenthesisStack.pop() != '[') {
                        return false
                    }
                }
                ')' -> {
                    if (startingParenthesisStack.isEmpty() || startingParenthesisStack.pop() != '(') {
                        return false
                    }
                }

            }
        }
        return startingParenthesisStack.isEmpty()
    }
}