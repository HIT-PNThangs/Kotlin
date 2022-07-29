package BaseCoffeMachine

class PremiumCoffeeMachine(
    price: Double,
    color: String
) : BaseCoffeeMachine(price, color) {
    fun makeCappuccino() {
        println("Here is your cappuccino")
    }
}