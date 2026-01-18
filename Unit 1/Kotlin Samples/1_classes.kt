/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
// Traditional class vs Data class comparison
data class User(
    // Properties
    // Notice how variables are declared in Kotlin
    val id: Int,
    val name: String,
    val email: String,
    val age: Int
)

fun main() {
    // Creating instances
    val user1 = User(1, "John Doe", "john@example.com", 25)
    val user2 = User(1, "John Doe", "john@example.com", 25)

    // Automatic toString() implementation
    println(user1) // Output: User(id=1, name=John Doe, email=john@example.com, age=25)

    // Automatic equals() implementation
    println(user1 == user2) // Output: true (compares values, not references)
}