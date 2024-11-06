package com.ksu.problemsolving

import java.util.Locale

fun main() {
    val intervals1 = listOf(listOf(1, 3), listOf(2, 6), listOf(8, 10), listOf(15, 18))
    //println() // Output: [[1, 6], [8, 10], [15, 18]]
    mergeIntervals(intervals1)
    println()
    println()
    val intervals2 = listOf(listOf(1, 4), listOf(4, 5), listOf(1, 4))
    mergeIntervals(intervals2)
    //println() // Output: [[1, 5]]
}

fun mergeIntervals(intervals: List<List<Int>>): List<List<Int>> {
    if (intervals.isEmpty()) return emptyList()
    println("given -> $intervals")
    // Sort intervals based on the starting time
    val sortedIntervals = intervals.sortedBy { it[0] }
    //println(sortedIntervals)
    println("sorted -> $sortedIntervals")
    val merged = mutableListOf<List<Int>>()

    var currentInterval = sortedIntervals[0]

    for (i in 1 until sortedIntervals.size) {
        val nextInterval = sortedIntervals[i]
        if (currentInterval[1] >= nextInterval[0]) {
            // Overlapping intervals, merge them
            currentInterval = listOf(currentInterval[0], maxOf(currentInterval[1], nextInterval[1]))
        } else {
            // No overlap, add the current interval to merged list and update currentInterval
            merged.add(currentInterval)
            currentInterval = nextInterval
        }
    }

    // Add the last interval
    merged.add(currentInterval)
    println("output -> $merged")
    return merged
}
