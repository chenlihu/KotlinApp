package com.example.kotlinapp.studykotlin

import kotlin.math.max

fun main() {
    println(largerNumber(10, 100))
    println(largerNumber1(12, 90))
    println(largerNumber2(12, 90))
    println(largerNumber3(12, 90))
    println(largerNumber4(12, 90))
}

fun largerNumber(num1: Int, num2: Int): Int {
    return max(num1, num2)
}

// 函数简写, 如果函数体只有一行就可以这么写，返回值类型也可以省略了因为能推导出来
fun largerNumber1(num1: Int, num2: Int) = max(num1, num2)

// if
fun largerNumber2(num1: Int, num2: Int): Int {
    var value = 0
    if (num1 > num2) {
        value = num1
    } else {
        value = num2
    }
    return value
}
// if 简写
fun largerNumber3(num1: Int, num2: Int): Int {
    val value = if (num1 > num2) {
        num1
    } else {
        num2
    }
    return value
}
fun largerNumber4(num1: Int, num2: Int) = if (num1 > num2) num1 else num2
