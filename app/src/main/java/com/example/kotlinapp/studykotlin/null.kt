package com.example.kotlinapp.studykotlin

fun main() {
    // 示例：创建一个 Animal 对象并调用 doAnimal 函数
    val dog: Animal = Dog()
    doAnimal(dog)
}

// 定义一个 Animal 接口
interface Animal {
    fun run()
    fun jump()
}

// 实现 Animal 接口的 Dog 类
class Dog : Animal {
    override fun run() {
        println("Dog is running!")
    }

    override fun jump() {
        println("Dog is jumping!")
    }
}

// 原始写法：直接调用可空对象的函数
fun doAnimal(animal: Animal?) {
    animal?.run()  // 如果 animal 不为 null，调用 run() 函数
    animal?.jump() // 如果 animal 不为 null，调用 jump() 函数
}

// 问题：上面的写法相当于下面的代码
fun doAnimal1(animal: Animal?) {
    if (animal !== null) {
        animal.run()  // 第一次检查 null
    }
    if (animal !== null) {
        animal.jump() // 第二次检查 null
    }
}

// 缺点：多次检查 null，代码冗余，不够简洁

// 优化：使用 `let` 函数
fun doAnimal2(animal: Animal?) {
    animal?.let { animal1 ->
        animal1.run()  // 在 let 函数内部，animal1 已经非空
        animal1.jump()
    }
}

// 进一步简化：省略参数名，使用默认的 `it`
fun doAnimal3(animal: Animal?) {
    animal?.let {
        it.run()  // 在 let 函数内部，it 已经非空
        it.jump()
    }
}