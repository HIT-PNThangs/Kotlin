package Student

class Student(
    var firstName: String,
    var lastName: String,
    var grades: MutableList<Grade> = mutableListOf(),
    var credits: Double = 0.0
) {
    fun recordGrade(grade: Grade) {
        grades.add(grade)
        credits += grade.credits
    }
}