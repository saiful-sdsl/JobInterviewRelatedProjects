package com.ksu.problemsolving

class RemoveDuplicateElements(
    var givenArray: IntArray
) {
    fun removeDuplicates(): IntArray{
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

    fun removeDuplicateElementsWithArrayList():IntArray{
        val returningArrayList = arrayListOf<Int>()

        for (item in givenArray){
            if(!returningArrayList.contains(item)) returningArrayList.add(item)
        }
        return returningArrayList.toIntArray()
    }
}