// Object initialization
data class User(
    var name: String = "",
    var email: String = "",
    var age: Int = 0
)

val user = User().apply {
    name = "Maria Garcia"
    email = "maria@example.com"
    age = 22
}

// Android View configuration
val textView = TextView(context).apply {
    text = "Welcome to Android"
    textSize = 18f
    setTextColor(Color.BLACK)
    setPadding(16, 16, 16, 16)
}

// Intent configuration
val intent = Intent(this, DetailActivity::class.java).apply {
    putExtra("USER_ID", userId)
    putExtra("USER_NAME", userName)
    flags = Intent.FLAG_ACTIVITY_NEW_TASK
}
startActivity(intent)
