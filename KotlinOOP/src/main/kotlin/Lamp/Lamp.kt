package Lamp

class Lamp(private var a: Boolean) {
    private var isOn: Boolean = a;

    fun getA(): Boolean {
        return a
    }

    fun setA(value: Boolean) {
        a = value
    }

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