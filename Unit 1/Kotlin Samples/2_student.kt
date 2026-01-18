// Model class for a Student Management app
data class Student(
    val studentId: String,
    val firstName: String,
    val lastName: String,
    val course: String,
    val gpa: Double
)

// Using copy() function to create modified versions
val student = Student("2024001", "Maria", "Santos", "Computer Science", 3.8)
val updatedStudent = student.copy(gpa = 3.9) // Only updates GPA, keeps other fields
