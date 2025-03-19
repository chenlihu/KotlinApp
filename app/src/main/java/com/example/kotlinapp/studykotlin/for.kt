package com.example.kotlinapp.studykotlin

// kotlin 中循环提供两种方式
// 1. while 和 java 一样
// 2. for 和 java 大不一样

fun main() {
    test1()
    test2()
    test3()
    test4()
    test5()
}

// kotlin 中循环，学好 for in 就可以了
fun test1() {
    // 0..10 创建一个两端闭合的空间数学表示 [0, 10]
    for (i in 0..10) {
        println(i)
    }
}
fun test2() {
    // 左闭右开在程序开发中更常用
    for (i in 0 until 10) {
        println(i)
    }
}
fun test3() {
    // 设置步长
    for (i in 0 until 10 step 2) {
        println(i)
    }
}
fun test4() {
    for (i in 10 downTo 1) {
        println(i)
    }
}
fun test5() {
    for (i in 10 downTo 1 step 2) {
        println(i)
    }
}