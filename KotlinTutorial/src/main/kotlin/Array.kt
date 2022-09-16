fun main() {
//    // arrayOf: bất biến
//    val a = arrayOf("Kotlin", "Programming", "Comic books")
//
//    println(a.size)
//    println(a[0])
//    println(a.get(2))
//
//    var i = 0
//    for(item in a) {
//        i += 1
//        println("$i: $item")
//    }
//
//    a.forEachIndexed{ index, item -> println("$index: $item") }

    val a = mutableListOf("Kotlin", "Programming", "Comic books")

    println(a.size)
    println(a[0])

    var i = 0
    for (item in a) {
        i += 1
        println("$i: $item")
    }

    a.forEachIndexed { index, item -> println("$index: $item") }

    a.add("Abc")

    a.forEachIndexed { index, item -> println("$index: $item") }

    val arr = mutableListOf<Int>(1, 2, 3, 4, 5)
    arr.forEach{
        println("$it: ${it * it}")
    }

    val arr2 = listOf(1, 2, 3, 4, 5, 6, 7).filter {
        it % 2 == 1
    }
    println(arr2)
}