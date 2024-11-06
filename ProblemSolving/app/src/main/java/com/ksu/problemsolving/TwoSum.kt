package com.ksu.problemsolving

class TwoSum(private val givenArray: IntArray, private val target:Int) {

    fun getResult():IntArray{
        println("Given Array: ${givenArray.joinToString()}")
        val result = IntArray(2)
        val givenArraySize = givenArray.size
        var found = false
        for (firstLoopIndex in 0 until (givenArraySize-1)){
            if (found) break
            //println("[OuterLoop]firstLoopIndex - $firstLoopIndex")
            for (secondLoopIndex in (firstLoopIndex+1) until givenArraySize){
               // println("[InnerLoop]secondLoopIndex - $secondLoopIndex")
                if(givenArray[firstLoopIndex] + givenArray[secondLoopIndex] == target){
                    result[0] = firstLoopIndex
                    result[1] = secondLoopIndex
                    found = true
                    println("Found the target Index")
                    break
                }
            }
        }
        return result
    }



}