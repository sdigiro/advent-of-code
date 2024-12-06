package org.example

import days.Day1
import org.example.days.Day2
import org.example.days.Day3
import java.io.File

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    // DAY 1
//    val day1 = Day1()
//
//    val exampleListA = readFileDay1("C:\\Users\\Sofia\\projects\\advent-of-code\\src\\main\\resources\\Day1\\exampleListA.txt")
//    val exampleListB = readFileDay1("C:\\Users\\Sofia\\projects\\advent-of-code\\src\\main\\resources\\Day1\\exampleListB.txt")
//
//    println("Day 1 Part 1 Example Answer: " + day1.day1part1(exampleListA, exampleListB))
//    println("Day 1 Part 2 Example Answer: " + day1.day1part2(exampleListA, exampleListB))
//
//    val listA = readFileDay1("C:\\Users\\Sofia\\projects\\advent-of-code\\src\\main\\resources\\Day1\\listA.txt")
//    val listB = readFileDay1("C:\\Users\\Sofia\\projects\\advent-of-code\\src\\main\\resources\\Day1\\listB.txt")
//
//    println("Day 1 Part 1 Answer: " + day1.day1part1(listA, listB))
//    println("Day 1 Part 2 Answer: " + day1.day1part2(listA, listB))

    // DAY 2
//    val day2 = Day2()
//
//    val exampleDataset = readFileDay2("C:\\Users\\Sofia\\projects\\advent-of-code\\src\\main\\resources\\Day2\\exampleDataset.txt")
//    println("Day 2 Part 1 Example Answer: " + day2.day2part1(exampleDataset))
//
//    val dataset = readFileDay2("C:\\Users\\Sofia\\projects\\advent-of-code\\src\\main\\resources\\Day2\\dataset.txt")
//    println("Day 2 Part 1 Answer: " + day2.day2part1(dataset))

    // DAY 3
    val day3= Day3()

    val exampleMemory = readFileDay3("C:\\Users\\Sofia\\projects\\advent-of-code\\src\\main\\resources\\Day3\\exampleMemory.txt")
    println("Day 3 Part 1 Example Answer: " + day3.day3part1(exampleMemory))

    val memory = readFileDay3("C:\\Users\\Sofia\\projects\\advent-of-code\\src\\main\\resources\\Day3\\memory.txt")
    println("Day 3 Part 1 Answer: " + day3.day3part1(memory))
}

fun readFileDay1(filePath: String): MutableList<Int> {
    val result = mutableListOf<Int>()

    File(filePath).bufferedReader().forEachLine { line ->
        result.add(line.toInt())
    }

    return result
}

fun readFileDay2(filePath: String): MutableList<MutableList<Int>> {
    val data = mutableListOf<MutableList<Int>>()

    File(filePath).bufferedReader().forEachLine { line ->
        val report = mutableListOf<Int>()

        line.split(" ").forEach { level ->
            report.add(level.toInt())
        }

        data.add(report)
    }

    return data
}

fun readFileDay3(filePath: String): String {
    return File(filePath).inputStream().readBytes().toString(Charsets.UTF_8)
}