package Lamp

class Lamp(a: Boolean) {
    private var isOn: Boolean = a;

    fun turnOn() {
        isOn = true
    }

    fun turnOff() {
        isOn = false
    }

    fun check() {
        if(isOn) println("Lamp is turn on")
        else println("Lamp is turn off")
    }
}