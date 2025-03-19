package com.example.kotlinapp.studykotlin

fun main(){
    println(getScore("Lily"))
    println(getScore1("Lily"))
    checkNumber(0)
}

// kotlin 中使用 when 来代替 java 中的 switch
fun getScore(name: String) = when (name) {
    "Tom" -> 80
    "Lily" -> 100
    else -> 60
}

// 类型判断 String Int 等类型都是 Number 的子类
fun checkNumber(num: Number) {
    when (num) {
        is Int -> println("Int")
        is Double -> println("Double")
        else -> println("other")
    }
}

// 不带参数的when
fun getScore1(name: String): Int {
    return when {
        name.startsWith("Tom") -> 80
        name == "Lily" -> 100
        else -> 60
    }
}