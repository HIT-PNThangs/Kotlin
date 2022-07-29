fun main() {
//    // mapOf: bất biến
//    val map = mapOf(1 to 'a', 2 to 'b', 3 to 'c')
//
//    map.forEach{ (key, value) -> println("$key -> $value") }

    val map = mutableMapOf(1 to 'a', 2 to 'b', 3 to 'c')
    map.forEach { (key, value) -> println("$key -> $value") }

    map.put(4, 'd')
    map.forEach { (key, value) -> println("$key -> $value") }

}