fun main() {
    val x : Pair<Int, Int> = Pair(2, 4)
    println(x)
    println(x.second)
    println(x.toList())
    println(x.toString())

    val y: Triple<Int, Int, Int> = Triple(1, 2, 3)
    println(y)
    println(y.second)
    println(y.toList())
    println(y.toString())
}