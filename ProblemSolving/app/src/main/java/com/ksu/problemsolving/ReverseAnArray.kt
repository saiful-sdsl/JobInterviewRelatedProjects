package com.ksu.problemsolving

class ReverseAnArray(private val givenArray: IntArray) {

    fun reverse(): IntArray {
        var sizeOfGivenArray = givenArray.size
        var temp =0
        for ((index,value) in givenArray.withIndex()){
            if(index>=sizeOfGivenArray) break
            temp = value
            givenArray[index] = givenArray[--sizeOfGivenArray]
            givenArray[sizeOfGivenArray] = temp
        }
        return givenArray
    }
}