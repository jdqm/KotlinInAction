package com.jdqm.kotlin.chapter5

fun main(args: Array<String>) {
    val people = listOf(Person("Kotlin", 20), Person("jetbrains", 21))
    people.map { it.name }.forEach { println(it)}

    val numbers = mapOf(0 to "zero", 1 to "one")
    println(numbers.mapValues { it.value.toUpperCase() })
    println(numbers.mapKeys { it.key + 1 })
    println(numbers.filterKeys { it == 0 })
    println(numbers.filterValues { it == "one" })

    val strings = listOf("abc", "def")
    println(strings.flatMap { it.toList() })

    val result = people.asSequence().map { it.name }.filter { it.startsWith("K") }.toList()
    println(result)
}