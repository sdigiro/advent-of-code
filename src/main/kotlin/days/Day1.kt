package days

import java.util.LinkedList
import kotlin.math.absoluteValue

class Day1 {
    // Day 1 Part 1
    // given two lists, pair the numbers from lowest to highest, calculate their differences, and sum the differences
    // for example, given [3, 4, 2] and [4, 3, 5]:
    //   pairs are: [2, 3], [3, 4], and [4, 5]
    //   differences are: [3 - 2 = 1], [4 - 3 = 1], and [5 - 4 = 1]
    //   sum of differences is: 1 + 1 + 1 = 3
    fun day1part1(listA: MutableList<Int>, listB: MutableList<Int>): Int {
        val matchedPairs = LinkedList<Pair<Int, Int>>()
        val pairDiffs = mutableListOf<Int>()

        while (listA.isNotEmpty() && listB.isNotEmpty()) {
            var lowestListA = listA[0]
            var lowestListB = listB[0]

            var lowestListAIndex = listA.indexOf(lowestListA)
            var lowestListBIndex = listB.indexOf(lowestListB)

            listA.forEach { valueA ->
                if(valueA < lowestListA) {
                    lowestListA = valueA
                    lowestListAIndex = listA.indexOf(valueA)
                }
            }

            listB.forEach { valueB ->
                if (valueB < lowestListB) {
                    lowestListB = valueB
                    lowestListBIndex = listB.indexOf(valueB)
                }
            }

            matchedPairs.add(Pair(lowestListA, lowestListB))

            listA.removeAt(lowestListAIndex)
            listB.removeAt(lowestListBIndex)
        }

        matchedPairs.forEach { pair ->
            val diff = (pair.first - pair.second).absoluteValue
            pairDiffs.add(diff)
        }

        var result = 0
        pairDiffs.forEach { diff ->
            result += diff
        }

        return result
    }

    // Day 1 Part 2
    // given two lists, determine how often each number in listA appears in listB, then determine the similarity score
    // similarity score = sum of (listA value * how often it appears in listB)
    fun day1part2(listA: MutableList<Int>, listB: MutableList<Int>): Int {
        val counts: MutableList<Pair<Int, Int>> = mutableListOf()
        var similarityScore = 0

        listA.forEach { valueA ->
            var count = 0
            listB.forEach { valueB ->
                if (valueB == valueA) {
                    count++
                }
            }

            counts.add(Pair(valueA, count))
        }

        counts.forEach { pair ->
            similarityScore += pair.first * pair.second
        }

        return similarityScore
    }
}