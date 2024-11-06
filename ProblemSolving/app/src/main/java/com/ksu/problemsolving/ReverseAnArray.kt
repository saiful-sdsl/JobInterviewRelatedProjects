package com.ksu.problemsolving

fun main(){
println("reversed array -> ${reverseV2(intArrayOf(1,2,3,4,5)).joinToString()}")
}

fun reverse(givenArray: IntArray): IntArray {
    var sizeOfGivenArray = givenArray.size
    var temp = 0
    for ((index, value) in givenArray.withIndex()) {
        if (index >= sizeOfGivenArray) break
        temp = value
        givenArray[index] = givenArray[--sizeOfGivenArray]
        givenArray[sizeOfGivenArray] = temp
    }
    return givenArray
}

fun reverseV2(givenArray: IntArray): IntArray {
    var endIndex = givenArray.size - 1
    var temp = 0
    var startIndex = 0
    while (startIndex < endIndex) {
        // Swap elements at startIndex and endIndex
        val temp = givenArray[startIndex]
        givenArray[startIndex] = givenArray[endIndex]
        givenArray[endIndex] = temp

        startIndex++
        endIndex--
    }
    return givenArray
}
