package org.example

import days.Day1
import java.io.File

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    // DAY 1
    val day1 = Day1()

//    val exampleListA = readFileDay1("C:\\Users\\Sofia\\projects\\advent-of-code\\src\\main\\resources\\Day1\\exampleListA.txt")
//    val exampleListB = readFileDay1("C:\\Users\\Sofia\\projects\\advent-of-code\\src\\main\\resources\\Day1\\exampleListB.txt")

//    println("Day 1 Part 1 Example Answer: " + day1.day1part1(exampleListA, exampleListB))
//    println("Day 1 Part 2 Example Answer: " + day1.day1part2(exampleListA, exampleListB))

    val listA = readFileDay1("C:\\Users\\Sofia\\projects\\advent-of-code\\src\\main\\resources\\Day1\\listA.txt")
    val listB = readFileDay1("C:\\Users\\Sofia\\projects\\advent-of-code\\src\\main\\resources\\Day1\\listB.txt")

//    println("Day 1 Part 1 Answer: " + day1.day1part1(listA, listB))
    println("Day 1 Part 2 Answer: " + day1.day1part2(listA, listB))
}

fun readFileDay1(filePath: String): MutableList<Int> {
    val result = mutableListOf<Int>()

    File(filePath).bufferedReader().forEachLine { line ->
        result.add(line.toInt())
    }

    return result
}