package com.ksu.problemsolving

class MergeTwoArray(
    private val givenArray1: IntArray,
    private val givenArray2: IntArray
    ) {

    fun mergeTwoArray(): IntArray {
        var incrementalIndex = 0
        val mergedArray = IntArray(givenArray1.size+givenArray2.size)
        for (item in givenArray1) mergedArray[incrementalIndex++] = item
        for (item in givenArray2) mergedArray[incrementalIndex++] = item
        return mergedArray
    }
}