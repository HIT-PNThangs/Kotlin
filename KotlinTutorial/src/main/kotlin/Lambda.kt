fun main() {
    val a : (Int, Int) -> Int = { x : Int, y: Int -> Int
        x * x + y * y}

    println(a(3, 4))
}