fun main() {
    // 2 cách khai báo biến
    // val: biến không đổi được
    // var: biến có thể đổi được
    // var/val <tên biến>: <kiểu dữ liệu> = ...
    // var/val <tên biến>: <kiểu dữ liệu> ? -> khai báo biến null có thể = null

    // in ra màn hình: print(), println()

    // Any: mọi kiểu dữ liệu

    val a : Any = "String"
    val b : Any = 123
    val c : Any = Pair(1, 2)

    println(a)
    println(b)
    println(c)
}