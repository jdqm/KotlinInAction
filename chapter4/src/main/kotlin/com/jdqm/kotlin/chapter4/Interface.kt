package com.jdqm.kotlin.chapter4

/**
 * 接口的使用
 */

interface Clickable {
    fun click()
    fun showOff() {
    }
}

interface Focusable {
    fun showOff() {

    }
}


class Button : Clickable, Focusable {
    override fun showOff() {
        super<Clickable>.showOff()
    }

    override fun click() {

    }
}

open class RichButton : Clickable {

    fun disable() {}

    open fun animate() {}


    override fun click() {

    }
}

class Re : RichButton() {
    override fun animate() {

    }
}
