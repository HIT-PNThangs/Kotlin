fun sum(a: Int, b: Int): Int {
    return a + b
}

fun xuat() {
    println(1234)
}

fun xuat1(str: String) {
    println("Hello $str!")
}

fun xuat2(str: String, arr: List<String>) {
    arr.forEach { item -> println("$str $item") }
}

fun xuat3(str: String, vararg arr: String) {
    arr.forEach { item -> println("$str $item") }
}

fun main() {
    println(sum(3, 4))
    xuat()

    xuat1("World")
    xuat1("Koltin")

    xuat2("String =", listOf("Abc", "Xyz"))

    xuat3("String =", "A", "B", "C")
    val arr = arrayOf("Abc", "Xyz")
    xuat3("String =", *arr)
}