package com.jdqm.kotlin.chapter4

/**
 * 1. object定义单实例
 * 2. 伴生对象
 */

interface Driver {
    fun onMount(driver: Driver)
    fun onUnMount(driver: Driver)
}

abstract class Player {
    abstract fun play(url: String)
    abstract fun stop()
}


//kotlin中的object类型（单例）
object MusicPlayer : Player(), Driver {
    override fun onMount(driver: Driver) {

    }

    override fun onUnMount(driver: Driver) {

    }

    var status: Int = 0

    override fun play(url: String) {}

    override fun stop() {}
}

//这种写法就类似于Java中的饿汉试单例
//class MusicPlayer1 {
//    public static MusicPlayer1 INSTANCE = new MusicPlayer1();
//    private MusicPlayer1(){}
//}

//fun main(args: Array<String>) {
//    MusicPlayer.play("hhh")
//    MusicPlayer.stop()
//}

//伴生对象
//在kotlin中没有像Java中的static关键字，更多的是包级函数，比如我们常用的工具类，因为Java是纯面向对象，所有代码都必须写在类里面
//当你在思考kotlin中如何写静态字段和方法时，考虑是否有必要。这时候伴生对象或包级函数也许是个不错的选择

class Logger {

    companion object {
        const val TAG = "InputEvent"
    }
}

//fun main(args: Array<String>) {
//    println(Logger.TAG)
//}

data class Client(val name: String, val postalCode: Int)

//fun main(args: Array<String>) {
//    val client = Client("广东", 888)
//    val c1 = client.copy(name = "广西", postalCode = 886)
//}

//使用by关键字委托

class CountingSet<T>(val innerSet: MutableCollection<T> = HashSet()) : MutableCollection<T> by innerSet {
    var objectAdd = 0

    override fun add(element: T): Boolean {
        objectAdd++
        return innerSet.add(element)
    }

    override fun addAll(elements: Collection<T>): Boolean {
        objectAdd += elements.size
        return innerSet.addAll(elements)
    }
}

//fun main(args: Array<String>) {
//    val countingSet: CountingSet<Int> = CountingSet()
//    countingSet.addAll(listOf(1, 1, 2))
//    println(countingSet.objectAdd)
//
//    //这个就是委托给 MutableCollection
//    println(countingSet.size)
//}

class Person(val firstName: String, val lastName: String) {
    companion object CompanionObj{

    }
}

//扩展伴生对象
fun Person.CompanionObj.fromJSON(json: String) : Person{
    //todo
    return Person("", "")
}

//fun main(args: Array<String>) {
//    Person.fromJSON("")
//}

//对象表达式，匿名内部类的另一种选择
class MouseEvent

interface MouseAdapter {
    fun moseClicked(e: MouseEvent)
    fun mouseEntered(e: MouseEvent)
}

class Window {
    fun addMoseListener(mouseAdapter: MouseAdapter){}
}

fun coutClicks(window: Window) {
    var clickCounts = 0

    window.addMoseListener(object : MouseAdapter{
        override fun moseClicked(e: MouseEvent) {

        }

        override fun mouseEntered(e: MouseEvent) {

        }
    })
}

fun main(args: Array<String>) {
    val listener = object : MouseAdapter {
        override fun mouseEntered(e: MouseEvent) {
        }

        override fun moseClicked(e: MouseEvent) {
        }

    }
}