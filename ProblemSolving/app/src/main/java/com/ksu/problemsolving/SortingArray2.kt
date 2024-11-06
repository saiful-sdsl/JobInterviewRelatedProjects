package com.ksu.problemsolving

class SortingArray2(
    private val givenArray:IntArray
) {
    fun sortAnArray(): IntArray{
       var temp =0
        for (i in 0 until givenArray.size -1)
            for (j in i+1 until givenArray.size){
                if(givenArray[i] > givenArray[j]){
                    temp = givenArray[i]
                    givenArray[i] = givenArray[j]
                    givenArray[j] = temp
                }
            }
        return givenArray
    }

    fun bubbleSort(givenArray: IntArray): IntArray {
        println("given array: ${givenArray.joinToString()}")

        var temp = 0

        for((firstIndex, _) in givenArray.withIndex()){
            for(secondIndex in firstIndex+1 until givenArray.size){
                if(givenArray[firstIndex] > givenArray[secondIndex])
                {
                    temp = givenArray[firstIndex]
                    givenArray[firstIndex] = givenArray[secondIndex]
                    givenArray[secondIndex] = temp
                }
            }
        }

        println("Sorted array: ${givenArray.joinToString()}")

        return givenArray


    }
}