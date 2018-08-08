package com.jdqm.kotlin.chapter5


fun main(args: Array<String>) {
    val num = listOf(1, 2, 3, 4, 5)
    num.filter { it % 2 == 1 }
            .forEach(::println)
}