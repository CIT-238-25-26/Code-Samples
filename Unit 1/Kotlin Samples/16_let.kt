// Null safety with let
val userName: String? = getUserName()
userName?.let {
    println("Welcome, $it")
    logUserActivity(it)
    updateUI(it)
} ?: println("No user found")

// Transforming values
val result = "Hello".let {
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