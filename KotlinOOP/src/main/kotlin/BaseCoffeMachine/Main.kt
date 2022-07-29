package BaseCoffeMachine

fun main() {
//    var coffeeMachine = BaseCoffeeMachine(100.0, "Red")
//    coffeeMachine.makeCoffee()

    var coffeeMachine1 = PremiumCoffeeMachine(100.0, "Red")
    coffeeMachine1.makeCappuccino()
    coffeeMachine1.makeCoffee()
}