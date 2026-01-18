fun main() {
    // Providing default values for null cases
    val userName: String? = null
    val displayName = userName ?: "Guest User"
    println(displayName) // Output: Guest User

    // Practical example
    // You need the class definition for User
    fun getUserAge(user: User?): Int {
        return user?.age ?: 0 // Returns 0 if user is null
    }

    // Look how functions are declared in Kotlin
    // fun as the keyword for function declaration
    // getUserAge is the function name
    // user: User? indicates that the parameter user can be of type User or null
    // : Int indicates that the function returns an Int type
}