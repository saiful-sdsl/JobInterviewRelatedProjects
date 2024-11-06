package com.ksu.problemsolving

fun main() {
    val inputValues = arrayOf(-1, -5, -4, 10, 20, 30)
    println("Original Array: ${inputValues.joinToString()}")
    println("After process the Array: ${removeDuplicates(inputValues).joinToString()}")
}

fun removeDuplicates(givenArray: Array<Int>): List<Int>{
    return givenArray.map { it * it }
}