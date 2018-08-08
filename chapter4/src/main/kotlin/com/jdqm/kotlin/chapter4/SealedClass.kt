package com.jdqm.kotlin.chapter4

/**
 * 密封类
 */

interface Expr

class Num(val value: Int) : Expr

class Sum(val left: Expr, val right: Expr) : Expr

fun eval(e: Expr): Int =
        when (e) {
            is Num -> e.value
            is Sum -> eval(e.left) + eval(e.right)
        //这种情况下必须带else分支，否则编译错误，试想一个情况，后续如Expr添加了子类，传进来，依然会走else，有可能导致一些微妙的错误。
        //此时使用sealed（密封）类是一个很好的选择。
            else ->
                throw IllegalArgumentException("Unknow expression")
        }


//密封类的所有子类都要写在其内部
sealed class Expression {
    class Num(val value: Int) : Expression()

    class Sum(val left: Expr, val right: Expr) : Expression()
}

//这种情况下就不需要写else，因为所有的类型你都要写一个is分支
fun eval(e: Expression): Int =
        when (e) {
            is Expression.Num -> e.value
            is Expression.Sum -> eval(e.left) + eval(e.right)
        }
