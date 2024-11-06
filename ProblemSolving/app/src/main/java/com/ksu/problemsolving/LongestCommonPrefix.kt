package com.ksu.problemsolving


fun main() {
    val strings1 = arrayOf("flower", "flow", "flight")
    println("Longest common prefix: ${longestCommonPrefix(strings1)}")
}

fun longestCommonPrefix(strings: Array<String>): String {
    if (strings.isEmpty()) return ""

    var prefix = strings[0]

    for (i in 1 until strings.size) {
        while (strings[i].indexOf(prefix) != 0) {
            prefix = prefix.substring(0, prefix.length - 1)
            if (prefix.isEmpty()) return ""
        }
        println("prefix -> $prefix")
    }

    return prefix
}
