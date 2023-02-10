package com.ksu.problemsolving

class StringReverse(private val givenString: String) {

    fun reverse(): String {
        var sizeOfGivenString = givenString.length
        val arrayOfGivenString = givenString.toCharArray()
        for ((index,value) in givenString.withIndex()) {
            if (index >= sizeOfGivenString) break
            arrayOfGivenString[index] = arrayOfGivenString[--sizeOfGivenString]
            arrayOfGivenString[sizeOfGivenString] = value
        }
        return String(arrayOfGivenString)
    }
}