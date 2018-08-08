package com.jdqm.kotlin.chapter4

/**
 * 抽象类相关
 */

abstract class Animated {
    //抽象方法默认为open
    abstract fun animate()

    open fun stopAnimating() {}

    //默认为final，不可覆盖
    fun animateTwice() {}
}

//Kotlin中写在类内部的类，对应的Java中的静态内部类，不持有外部类的的引用。若要定义内部类需要，需要通过inner关键字来定义。

class OuterClass {
    class JavaStaticClass {
        //编译错误
        //fun getOuter(): OuterClass = this@OuterClass
    }

    inner class InnerClass {
        fun getOuter(): OuterClass = this@OuterClass
    }
}
