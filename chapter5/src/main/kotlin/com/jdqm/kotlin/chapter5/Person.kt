package com.jdqm.kotlin.chapter5

data class Person(val name: String, val age: Int)


fun main(args: Array<String>) {
    //使用lambda表达式找出年龄最大的人
    val people = listOf(Person("Kotlin", 20), Person("jetbrains", 21))
    val person = people.maxBy { it.age }
    println(person)

    //引用属性
    val getAge = Person::age

    println(people.minBy(getAge))

    //引用包级函数
    people.forEach(::print)
}
