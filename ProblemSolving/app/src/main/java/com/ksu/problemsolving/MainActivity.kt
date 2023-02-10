package com.ksu.problemsolving

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val givenArray1 = intArrayOf(1, 2, 2, 3, 1, 8, 4, 4, 5, 5)
        val givenArray2 = intArrayOf(1, 2, 9, 3, 1, 8, 4, 4, 5, 5)

        println("Given Array 1: ${givenArray1.joinToString()}")
        println("Given Array 2: ${givenArray2.joinToString()}")

        val mergedArray = MergeTwoArray(givenArray1, givenArray2).mergeTwoArray()
        println("After merging arrays: ${mergedArray.joinToString()}")

        val arrayWithoutDuplicates =
            RemoveDuplicateElements(mergedArray).removeDuplicates()
        println("After removing duplicates: ${arrayWithoutDuplicates.joinToString()}")

        val sortedArray = SortingArray(arrayWithoutDuplicates).sortAnArray()
        println("After sorting: ${sortedArray.joinToString()}")

        val reversedArray = ReverseAnArray(sortedArray).reverse()
        println("After reversed: ${reversedArray.joinToString()}")

        val reversedString = StringReverse("sortedArray").reverse()
        println("After reversed sortedArray: $reversedString")


        val largestElement = FindLargestElement(sortedArray).findLargestElement()
        println("Largest number in array: $largestElement")

        val resultArray = TwoSum(sortedArray, 9).getResult()
        println("Two Sum result: ${resultArray.joinToString()}")


        val equivalentIntNumber = RomanToInteger(
            arrayOf(
                "MCMXCIV",
                "III",
                "LVIII",
                "MMMDCCXXIV"
            )
        ).getEquivalentIntegerNumbers()
        println("Roman to Int results: ${equivalentIntNumber.joinToString()}")

        val arrayOfFindingLongestPrefixString = arrayOf("flower", "flower", "flower")
        val longestCommonPrefix = LongestCommonPrefix(arrayOfFindingLongestPrefixString).getLongestCommonPrefix()
        println("Longest common prefix of ${arrayOfFindingLongestPrefixString.joinToString()} is $longestCommonPrefix")


        val arrayOfFindingValidParenthesis = arrayOf("(){}[]", "[]({}", "{}{}[]()()", "[{()}]")
        val resultOfFindingValidParenthesis = ValidParenthesisChecker(arrayOfFindingValidParenthesis).checkIfValid()
        println("Result of finding common parenthesis ${arrayOfFindingValidParenthesis.joinToString()} is ${resultOfFindingValidParenthesis.joinToString()}")



        val list = ArrayList<SortUsingComparator.Name>()

        list.add(SortUsingComparator.Name("saiful","islam"))
        list.add(SortUsingComparator.Name("sharaban","tahora"))
        list.add(SortUsingComparator.Name("bilash","shaha"))
        list.add(SortUsingComparator.Name("arabin","talukdar"))

        println("Before sort")
        println(list.joinToString())

        list.sortWith(SortUsingComparator.NameSortComparatorUsingFirstName())

        println("After sort with firstName")
        println(list.joinToString())

        list.sortWith(SortUsingComparator.NameSortComparatorUsingLastName())

        println("After sort with lastName")
        println(list.joinToString())

    }
}