// Scope functions execute a block of code within the context of an object.
// i.e. it enables you to call methods or access properties of an object without explicitly referencing the object.

fun main() {
    // Null safety with let
    val userName: String? = getUserName()
    // This is the not explicit way
    userName?.let {
        // We assumme that these functions are defined elsewhere
        println("Welcome, $it")
        logUserActivity(it)
        updateUI(it)
    } ?: println("No user found")

    // Transforming values
    val result = "Hello".let {
        // it refers to the string "Hello"
        val uppercase = it.uppercase()
        uppercase.length
    }
    println(result) // Output: 5

    // Android example: Intent extras
    val userId = intent.getStringExtra("USER_ID")?.let { id ->
        fetchUserData(id)
        displayUserProfile(id)
        id.toInt()
    }
}