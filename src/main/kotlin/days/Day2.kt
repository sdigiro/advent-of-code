package org.example.days

import kotlin.math.absoluteValue

class Day2 {
    // Day 2 Part 1
    // the data consists of many reports, one per line
    // each report is a list of numbers called levels that are separated by spaces
    // example containing 6 reports, each with 5 levels:
    //   7 6 4 2 1 // safe (levels all decreasing by 1 or 2)
    //   1 2 7 8 9 // unsafe (2 -> 7 is an increase of 5)
    //   9 7 6 2 1 // unsafe (6 -> 2 is a decrease of 4)
    //   1 3 2 4 5 // unsafe (1 -> 3 is an increase of 2 which is safe, but 3 -> is then decreasing)
    //   8 6 4 4 1 // unsafe (4 -> 4 is stagnant)
    //   1 3 6 7 9 // safe (levels all increasing by 1, 2, or 3)

    // given a dataset similar to the above example, determine how many reports are safe
    // a report is safe iff the levels are all decreasing or all increasing AND any two adjacent levels differ by at least 1 and at most 3
    // see above for safe/unsafe reports in the example dataset
    fun day2part1(dataset: List<List<Int>>): Int {
        var safeCount = 0

        dataset.forEach { report ->
            val isAllInc = findIfAllIncreasing(report)
            val isAllDec = findIfAllDecreasing(report)
            val isSafeDiff = findIfSafeDiff(report)

            if ((isAllInc || isAllDec) && isSafeDiff) {
                safeCount++
            }
        }

        return safeCount
    }

    private fun findIfSafeDiff(report: List<Int>): Boolean {
        var isSafe = false
        var diff: Int

        if (findIfAllIncreasing(report) || findIfAllDecreasing(report)) {
            report.forEach { level ->
                if (report.indexOf(level) < report.size - 1) {
                    if (level == report[report.indexOf(level) + 1]) {
                        return false
                    } else {
                        diff = (level - report[report.indexOf(level) + 1]).absoluteValue

                        if (diff in 1..3) {
                            isSafe = true
                        } else {
                            return false
                        }
                    }
                } else {
                    return isSafe
                }
            }
        }

        return isSafe
    }

    private fun findIfAllIncreasing(report: List<Int>): Boolean {
        var isInc = false

        report.forEach { level ->
            if (report.indexOf(level) < report.size - 1) {
                if (level < report[report.indexOf(level) + 1]) {
                    isInc = true
                } else {
                    return false
                }
            } else {
                return isInc
            }
        }

        return false
    }

    private fun findIfAllDecreasing(report: List<Int>): Boolean {
        var isDec = false

        report.forEach { level ->
            if (report.indexOf(level) < report.size - 1) {
                if (level > report[report.indexOf(level) + 1]) {
                    isDec = true
                } else {
                    return false
                }
            } else {
                return isDec
            }
        }

        return false
    }
}