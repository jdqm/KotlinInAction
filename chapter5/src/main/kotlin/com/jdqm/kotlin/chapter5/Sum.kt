package com.jdqm.kotlin.chapter5

/**
 * lambda表达式的一般格式
 * {参数列表->语句块}
 * 如：{x: Int，y: Int -> x + y}
 *
 * note: 当参数列表的最后一个参数时lambda表达式，可以把表达式移到小括号外面，如果小括号里没有其他参数，那小括号也可以省略
 */

val sum = {x: Int, y: Int -> x + y}

fun main(args: Array<String>) {
    println(sum(1, 2));
    { print(42)}()
}

