package com.example.kotlinapp.studykotlin

import kotlin.text.StringBuilder
/*
带接收者的 Lambda 是 Kotlin 中的一种特殊 Lambda 表达式，它允许在 Lambda 内部直接访问某个对象的成员（属性和方法），而无需显式引用该对象（如 this 或变量名）。它的核心特点是：
有一个隐式的接收者（this），在 Lambda 内部可以直接调用该接收者的方法或访问属性。
语法形式：ReceiverType.() -> ReturnType，例如 StringBuilder.() -> Unit。


StringBuilder.build 是扩展函数。扩展函数 是 Kotlin 语言中的一个强大特性，它允许你为现有的类添加新的函数，
而无需修改类的源代码或继承该类。
 */
fun StringBuilder.build(block: StringBuilder.() -> Unit): StringBuilder {
    block()
    return this
}

fun buildString(action: StringBuilder.() -> Unit): StringBuilder {
    val str = StringBuilder()
    str.action()
    return str
}

fun main() {
    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
    val result = StringBuilder().build {
        append("Start eating fruits.\n")
        for (fruit in list) {
            append(fruit).append("\n")
        }
        append("Ate all fruits.")
    }
    println(result.toString())

    println("--------------------------------------------------------------")

    var ret = buildString {
        append("Start eating fruits.\n")
        for (fruit in list) {
            append(fruit).append("\n")
        }
        append("Ate all fruits.")
    }
    println(ret.toString())
}