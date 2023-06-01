@file:JvmName("Main")

package me.xtrm.postprocessor.example

class Person(
    private val name: String,
) {
    fun sayHello() {
        println("$name > Hello!")
    }
}

fun main() {
    val person = Person("John")
    person.sayHello()
}
