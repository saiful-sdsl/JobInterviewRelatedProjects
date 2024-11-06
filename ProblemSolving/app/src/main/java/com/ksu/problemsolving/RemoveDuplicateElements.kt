package com.ksu.problemsolving


fun main() {
    removeDuplicateElementsWithSet(intArrayOf(3,2,4,2,3,2,3,2,4,5,6,7,8))
}
    fun removeDuplicates(givenArray: IntArray): IntArray{
        val workingArray = IntArray(givenArray.size)
        var incrementalIndex = 0
        for (item in givenArray){
            var duplicateElements = false
            for (itemInResultArray in workingArray){
                if(item == itemInResultArray){
                    duplicateElements = true
                }
            }
            if(!duplicateElements)  workingArray[incrementalIndex++] = item
        }
        val returningArray = IntArray(incrementalIndex)
        for (j in 0 until incrementalIndex) returningArray[j] = workingArray[j]
        return returningArray
    }

    fun removeDuplicateElementsWithArrayList(givenArray: IntArray):IntArray{
        val returningArrayList = arrayListOf<Int>()

        for (item in givenArray){
            if(!returningArrayList.contains(item)) returningArrayList.add(item)
        }
        return returningArrayList.toIntArray()
    }

    fun removeDuplicateElementsWithSet(givenArray: IntArray
    ):IntArray{
        val returningList = mutableSetOf<Int>()

        for (item in givenArray){
            returningList.add(item)
        }
        println("given -> ${givenArray.joinToString()}")
        println("after removing duplicates -> $returningList")
        return returningList.toIntArray()
    }
