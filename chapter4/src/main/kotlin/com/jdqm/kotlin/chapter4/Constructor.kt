package com.jdqm.kotlin.chapter4

/**
 * 主从构造方法
 */

//主构造方法
class User1 constructor(nickname: String) {
    val nickname: String

    //初始化块，可以有多个
    init {
        this.nickname = nickname
    }

    init {
        //todo
    }

    //从构造方法，可以有多个从构造函数
    constructor(nickname: String, age: Int) : this(nickname) {
        //todo
    }

    constructor(nickname: String, sex: Boolean) : this(nickname) {
        //todo
    }
}

//简化，主构造函数私有化
class User private constructor(nickname: String) {
    val nickname: String = nickname
}


//简写，这种方式主构造方法不能写访问修饰符，默认为public
class User2(val nickname: String)