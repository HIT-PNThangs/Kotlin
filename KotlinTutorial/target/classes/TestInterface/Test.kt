package TestInterface

import Test.Person

interface Test {
    fun printInformation(person: Person)
}

abstract class BasicInfoProvider: Test {
    override fun printInformation(person: Person) {
        println("Print Information")
    }
}

fun main() {
    val provider: BasicInfoProvider

//    provider.printInformation(Person())
}