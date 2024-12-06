package org.example.days

import java.util.regex.Pattern

class Day3 {
    fun day3part1(memory: String): Int {
        var result = 0
        val matchList = mutableListOf<String>()

        val mulRegex = Regex("mul\\([0-9]+,[0-9]+\\)")
        val mulRegexPattern = Pattern.compile(mulRegex.pattern)
        val mulRegexMatcher = mulRegexPattern.matcher(memory)

        while (mulRegexMatcher.find()) {
            matchList.add(mulRegexMatcher.group())
        }

        matchList.forEach { match ->
            val numRegex = Regex("[0-9]+")
            val numRegexPattern = Pattern.compile(numRegex.pattern)
            val numRegexMatcher = numRegexPattern.matcher(match)

            val numPair = mutableListOf<String>()
            while (numRegexMatcher.find()) {
                numPair.add(numRegexMatcher.group())
            }

            result += mul(numPair[0].toInt(), numPair[1].toInt())
        }

        return result
    }

    private fun mul(num1: Int, num2: Int): Int {
        return num1 * num2
    }
}