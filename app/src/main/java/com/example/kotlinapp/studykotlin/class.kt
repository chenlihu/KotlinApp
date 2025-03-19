package com.example.kotlinapp.studykotlin

fun main() {
    val a = Student("lily", 10, 10)
    a.say()
}
class Student(name: String, age: Int, val grade: Int): Person(name, age), Study {
    override fun say() {
        println(" name: $name age: $age grade: $grade")
    }

    override fun doStudy() {
        println("doStudy")
    }
}
open class Person(val name: String, val age: Int) {
    open fun say() {
        println("name: " + name + "age: " + age)
    }
}
interface Study {
    fun doHomeWork() {
        println("有默认实现，子类可以选择不重写")
    }
    fun doStudy()
}