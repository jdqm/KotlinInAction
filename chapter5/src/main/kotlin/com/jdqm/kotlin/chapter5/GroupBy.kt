package com.jdqm.kotlin.chapter5

fun main(args: Array<String>) {
    val people = listOf(Person("Alice", 27), Person("Bob", 31))
    val result = people.groupBy { it.age }
    result.forEach{println(it)}
}