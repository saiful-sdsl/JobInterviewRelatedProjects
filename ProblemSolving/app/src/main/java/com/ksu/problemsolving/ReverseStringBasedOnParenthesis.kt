package com.ksu.problemsolving

import java.util.Stack

fun main() {
    val inputValues = arrayOf(-1, -5, -4, 10, 20, 30)
    println("Original Array: ${inputValues.joinToString()}")
    //val inputString = "(abcd(le))"
    val inputString = "(ed(et(oc))el)"
    //val inputString = "(abc(cde))"
    println("After process the String $inputString -> ${reverseStringBasedOnParenthesis(inputString)}")
    println(
        "After process the String $inputString -> ${
            reverseStringBasedOnParenthesisV2(
                inputString
            )
        }"
    )
}

fun reverseStringBasedOnParenthesis(givenString: String): String {
    if (givenString.isEmpty()) return givenString
    val characterStack = Stack<StringBuilder>()
    var currentString = StringBuilder()

    for (aChar in givenString) {
        when (aChar) {
            '(' -> {
                characterStack.add(currentString)
                currentString = StringBuilder()
            }

            ')' -> {
                val reversedString = currentString.reverse()
                val lastSubString = characterStack.pop()
                currentString = lastSubString.append(reversedString)
            }

            else -> {
                currentString.append(aChar)
            }
        }
    }

    return currentString.toString()
}

fun reverseStringBasedOnParenthesisV2(givenString: String): String {
    if (givenString.isEmpty()) return givenString

    val stack = Stack<StringBuilder>()
    var currentString = StringBuilder()

    for (char in givenString) {
        when (char) {
            '(' -> {
                stack.push(currentString) // Save the current segment
                currentString = StringBuilder() // Start a new segment
            }

            ')' -> {
                currentString.reverse() // Reverse the current segment
                val lastSegment = stack.pop() // Get the previous segment
                currentString =
                    lastSegment.append(currentString) // Append reversed current segment to the previous one
            }

            else -> currentString.append(char) // Append character to the current segment
        }
    }

    return currentString.toString()
}