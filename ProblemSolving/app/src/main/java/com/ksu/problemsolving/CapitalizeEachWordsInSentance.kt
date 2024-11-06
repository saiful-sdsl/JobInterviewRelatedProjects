package com.ksu.problemsolving

import java.util.Locale

fun main() {
    val inputString = "hello world from kotlin world"
    println("Original String: $inputString")
    println("After process the String: ${capitalizeWords(inputString)}")
}

fun capitalizeWords(inputString: String): String {
    val splitString = inputString.split(" ")
    val capitalizeString = splitString.map { word -> word.capitalize() }
    var finalString = ""
    for (words in capitalizeString) {
        finalString += "$words "
    }
    return finalString.trim()
}

fun capitalizeWords2(input: String): String {
    // Split the input string into words
    return input.split(" ")
        .joinToString(" ") { word ->
            // Check if the word is non-empty to avoid errors
            if (word.isNotEmpty()) {
                // Manually capitalize the first letter and concatenate the rest
                word[0].uppercase() + word.substring(1).lowercase()
            } else {
                word  // For empty strings, just return the word itself
            }
        }
}