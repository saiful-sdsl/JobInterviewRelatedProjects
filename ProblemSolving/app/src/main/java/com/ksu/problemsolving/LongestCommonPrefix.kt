package com.ksu.problemsolving

class LongestCommonPrefix(private val givenArray:Array<String>) {



    fun getLongestCommonPrefix(): String{
        // if emtpy array return empty result
        if (givenArray.isEmpty()) return ""

        val giveArraySize = givenArray.size
        var resultingString = ""
        var matchedPrefixCount: Int
        var currentIndex = 0

        initialLoop@
        for (aChar in givenArray[0]){
            matchedPrefixCount = 0
            for (aString in givenArray){
                if(aString.isEmpty()) {
                    return ""
                }
                if(isCharMatched(aString,currentIndex, aChar)) ++matchedPrefixCount
            }
            if(matchedPrefixCount == giveArraySize) resultingString += aChar
            else break@initialLoop

            ++currentIndex

        }
        return resultingString
    }

    private fun isCharMatched(aString:String, index: Int, aMatchingChar:Char): Boolean{
        return aString.length>index && aString[index] == aMatchingChar
    }
}