package com.ksu.problemsolving

class SortingArray(
    private val givenArray:IntArray
) {
    fun sortAnArray(): IntArray{
        var temp = 0
        for (firstIndex in 0..givenArray.size-2)
            for (secondIndex in firstIndex+1 until givenArray.size ){
              if(givenArray[firstIndex]> givenArray[secondIndex])
              {
                  temp = givenArray[firstIndex]
                  givenArray[firstIndex] = givenArray[secondIndex]
                  givenArray[secondIndex] = temp
              }
            }
        return givenArray
    }
}