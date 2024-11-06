package com.ksu.problemsolving

fun main(){
    val input = 121
println("is $input isPalindrome -> ${checkPalindrome(input)}")
println("is $input isPalindrome -> ${checkPalindromeV2(input)}")
}

fun checkPalindrome(inputValue: Int): Boolean{

    val inputValueAsString = inputValue.toString()
    return inputValueAsString == inputValueAsString.reversed()

}

fun checkPalindromeV2(inputValue: Int): Boolean {
    if(inputValue < 0) return false

    var reverseValue = 0
    var originalValue = inputValue
    while (originalValue % 10 != 0){
        val divisor = originalValue%10
        val division = originalValue/10
        reverseValue = reverseValue * 10 + divisor
        originalValue = division
    }

    return reverseValue == inputValue
}
