package com.ksu.problemsolving

class FindLargestElement(private val givenArray: IntArray) {

    fun findLargestElement(): Int{
        var largestElement = 0;
        for (item in givenArray) if(item > largestElement) largestElement = item
        return largestElement
    }
}