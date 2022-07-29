import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)

    print("Nhap: a = ")
    var a: Int = sc.nextInt()
    a += 1
    println("a = ${a * a}")

    print("Nhap: b = ")
    var b: Float = sc.nextFloat()
    b += 2.0f
    println("b = ${b - a}")

    sc.nextLine()
    print("Nhap chuoi: str = ")
    val str: String = sc.nextLine()
    println("str = $str")
}