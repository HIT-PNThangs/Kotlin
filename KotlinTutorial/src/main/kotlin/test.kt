fun main() {
    // 2 cách khai báo biến
    // val: biến không đổi được
    // var: biến có thể đổi được
    // var/val <tên biến>: <kiểu dữ liệu> = ...
    // var/val <tên biến>: <kiểu dữ liệu> ? -> khai báo biến null có thể = null

    // in ra màn hình: print(), println()

    val b: String ? = null

    val a = when(b) {
        null -> "hi"
        else -> "hello"
    }

    print(a)
}