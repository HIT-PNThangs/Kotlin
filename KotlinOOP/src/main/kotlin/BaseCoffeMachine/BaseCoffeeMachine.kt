package BaseCoffeMachine

open class BaseCoffeeMachine(
    private var price: Double,
    private var color: String
) {
    fun makeCoffee() {
        println("Here is your coffee")
    }
}