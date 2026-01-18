data class Student(val name: String, val grade: Int)

fun main() {
    val students = listOf(
        Student("Alice", 85),
        Student("Bob", 92),
        Student("Charlie", 78),
        Student("Diana", 95)
    )

    // forEach - iterate through collection
    students.forEach { student ->
        println("${student.name}: ${student.grade}")
    }

    // filter - select elements matching condition
    val topStudents = students.filter { it.grade >= 90 }

    // map - transform elements
    val names = students.map { it.name }

    // sortedBy - sort by property
    val sorted = students.sortedBy { it.grade }

    // any, all, none - boolean checks
    val hasExcellentStudent = students.any { it.grade >= 95 }
    val allPassed = students.all { it.grade >= 75 }

}