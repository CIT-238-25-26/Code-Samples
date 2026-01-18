// Maps, on the other hand, are collections of key-value pairs. 
// They allow you to associate a value with a specific key, enabling efficient data retrieval based on that key. 

fun main() {
    // Read-only map
    val grades = mapOf(
        "Math" to 95,
        "Science" to 92,
        "English" to 88
    )
    println(grades["Math"]) // Output: 95

    // Mutable map
    val userProfiles = mutableMapOf<String, String>()
    userProfiles["user001"] = "John Doe"
    userProfiles["user002"] = "Jane Smith"
    userProfiles.put("user003", "Bob Johnson")

    // Iterating through maps
    for ((subject, grade) in grades) {
        println("$subject: $grade")
    }

    // Safe access with Elvis operator
    val historyGrade = grades["History"] ?: 0

}