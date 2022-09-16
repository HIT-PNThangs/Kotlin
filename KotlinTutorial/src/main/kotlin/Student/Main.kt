package Student

fun main() {
    val student = Student("John", "Son")
    val a = Grade("B", 15.0, 3.0)
    val b = Grade("A", 19.0, 4.0)
    val c = Grade("C", 10.0, 2.0)

    student.recordGrade(a)
    student.recordGrade(b)
    student.recordGrade(c)

    println(student.credits)
    println(student.grades)
}