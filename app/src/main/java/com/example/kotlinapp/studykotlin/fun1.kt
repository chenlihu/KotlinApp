package com.example.kotlinapp.studykotlin

fun main() {
    // 示例：使用主构造函数创建对象
    val p1 = Person1("mary") // 只提供 name，age 和 sex 使用默认值
    val p2 = Person1(sex = "男", age = 18) // 使用命名参数，name 使用默认值

    println("p1: name=${p1.name}, age=${p1.age}, sex=${p1.sex}")
    println("p2: name=${p2.name}, age=${p2.age}, sex=${p2.sex}")
}

// 定义一个 Person1 类，使用主构造函数和默认参数值
class Person1(val name: String = "lily", val age: Int = 10, val sex: String = "女") {
    // 主构造函数中定义的属性可以直接在类中使用
}