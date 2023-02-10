package com.ksu.problemsolving

class RomanToInteger(private val romanNumbers: Array<String>) {
    private val romanMap =
        mapOf('I' to 1, 'V' to 5, 'X' to 10, 'L' to 50, 'C' to 100, 'D' to 500, 'M' to 1000)

    fun getEquivalentIntegerNumbers(): ArrayList<Int>{
        val equivalentIntegerNumber = arrayListOf<Int>()
        for (aRomanNumber in romanNumbers){
            equivalentIntegerNumber.add(getIntegerValue(aRomanNumber))
            println("$aRomanNumber = ${getIntegerValue(aRomanNumber)}")
        }
        return equivalentIntegerNumber
    }
    private fun getIntegerValue(romanNumber: String): Int {
        if (romanNumber.isEmpty()) return 0
        var sum = 0
        val charArray = romanNumber.toCharArray()
        var charIndex = 0

        while (charIndex < charArray.size) {
            if (charIndex + 1 == charArray.size) {
                sum += getNumberValue(charArray[charIndex])
                break
            }
            if (getNumberValue(charArray[charIndex]) >= getNumberValue(charArray[charIndex + 1])) {
                sum += getNumberValue(charArray[charIndex])
                ++charIndex
            } else {
                sum += (getNumberValue(charArray[charIndex + 1]) - getNumberValue(charArray[charIndex]))
                charIndex += 2
            }
        }

        return sum
    }

    private fun getNumberValue(char: Char): Int {
        return romanMap[char] ?: 0
    }
}