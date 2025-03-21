package com.example.kotlinapp

fun main() {
    with_test()
    run_test()
    apply_test()
    let_test()
}

/**
 * with 函数示例
 * with 函数接收一个对象和一个 Lambda 表达式，将对象作为 Lambda 的接收者（this），并返回 Lambda 的结果。
 * 适合对一个对象进行多次操作。
 */
fun with_test() {
    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")

    // 传统写法
    val builder = StringBuilder()
    builder.append("Start eating fruits.\n")
    for (fruit in list) {
        builder.append(fruit).append("\n")
    }
    builder.append("Ate all fruits.")
    val result = builder.toString()
    println(result)

    // 使用 with 简化
    val result1 = with(StringBuilder()) {
        append("Start eating fruits.\n")
        for (fruit in list) {
            append(fruit).append("\n")
        }
        append("Ate all fruits.")
        toString() // 返回最后一行表达式的结果
    }
    println(result1)
}

/**
 * run 函数示例
 * run 函数与 with 类似，但它以扩展函数的形式调用，接收一个 Lambda 表达式，返回 Lambda 的结果。
 * 适合对对象进行初始化或计算并返回结果。
 */
fun run_test() {
    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")

    val result = StringBuilder().run {
        append("Start eating fruits.\n")
        for (fruit in list) {
            append(fruit).append("\n")
        }
        append("Ate all fruits.")
        toString() // 返回最后一行表达式的结果
    }
    println(result)
}

/**
 * apply 函数示例
 * apply 函数以扩展函数的形式调用，接收一个 Lambda 表达式，返回对象本身。
 * 适合对对象进行初始化或配置。
 */
fun apply_test() {
    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")

    val builder = StringBuilder().apply {
        append("Start eating fruits.\n")
        for (fruit in list) {
            append(fruit).append("\n")
        }
        append("Ate all fruits.")
    }
    println(builder.toString())
}

/**
 * let 函数示例
 * let 函数以扩展函数的形式调用，接收一个 Lambda 表达式，将对象作为 Lambda 的参数（it），并返回 Lambda 的结果。
 * 适合对非空对象进行操作或链式调用。
 */
fun let_test() {
    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")

    val result = StringBuilder().let { builder ->
        builder.append("Start eating fruits.\n")
        for (fruit in list) {
            builder.append(fruit).append("\n")
        }
        builder.append("Ate all fruits.")
        builder.toString() // 返回最后一行表达式的结果
    }
    println(result)
}