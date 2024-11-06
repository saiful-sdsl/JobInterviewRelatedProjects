package com.ksu.problemsolving

fun main() {
    val sortedArray = arrayOf(1,2,3,4,4,5,6,7,9)
    println("Original Array: ${sortedArray.joinToString()}")
    println("After removing duplicates from sorted Array: ${removeDuplicates(sortedArray, sortedArray.size).joinToString()}")
}

fun removeDuplicates(givenArray: Array<Int>, givenArraySize: Int): IntArray{

    val returningArray = IntArray(givenArraySize)

    if(givenArraySize == 0 || givenArraySize ==1) return givenArray.toIntArray()

    var returningArrayIndex = 0

    for (i in 0 until givenArraySize-1){
        if(givenArray[i]!=givenArray[i+1]) returningArray[returningArrayIndex++] = givenArray[i]
    }

    returningArray[returningArrayIndex++] = givenArray[givenArraySize-1]

    var finalArray = IntArray(returningArrayIndex)
    for (i in 0 until returningArrayIndex)
        finalArray[i] = returningArray[i]

   return finalArray
}