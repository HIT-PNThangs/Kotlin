package Lamp

fun main() {
    val a = Lamp(true)

    a.check()

    a.turnOff()
    a.check()

    a.turnOn()
    a.check()
}