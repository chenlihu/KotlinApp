package com.example.kotlinapp.studykotlin

fun main() {
    list_test()
    lamda_test()
}

fun list_test() {
    val list1 = listOf("a", "b") // 不可变list，不可以向集合内添加元素
    val mutableList = mutableListOf("a", "b") // 可以向list内添加元素
    val set = setOf("a", "b") // 不可变set
    val mutableSet = mutableSetOf("a", "b") // 可变set
    val map1 = mapOf("m1" to 1, "m2" to 2)
    val mutableMap1 = mutableMapOf("mm1" to 1, "mm2" to 2)
    for (l in list1) {
        println(l)
    }
    for (l1 in set) {
        println(l1)
    }
    for ((k, v) in map1) {
        println("key: $k, value: $v")
    }
}

fun lamda_test() {
    val list = listOf("Apple", "Banana", "Orange")

    // 原始方式
    val lamda = { fruit: String -> fruit.length }
    val ret1 = list.maxBy(lamda)

    // 简化
    val ret2 = list.maxBy({ fruit: String -> fruit.length })

    // 当lamda参数是函数的最后一个参数的话， lamda可以写到括号外面
    val ret3 = list.maxBy() { fruit: String -> fruit.length }

    // 当lamda参数是函数的唯一一个参数的话，括号可以省掉
    val ret4 = list.maxBy { fruit: String -> fruit.length }

    // 省略类型
    val ret5 = list.maxBy { fruit -> fruit.length }

    // landa 表达式只有一个参数，可以用it，更简化了。
    val maxLengthStr = list.maxBy { it.length }
    println("maxLengthStr: $maxLengthStr")
}