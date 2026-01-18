class UserRepository {
    fun registerUser(email: String, password: String): User? {
        // Create user with validation
        return User().apply {
            this.email = email
            this.password = hashPassword(password)
            createdAt = System.currentTimeMillis()
        }.also {
            // Side effects: logging and saving
            Log.d("UserRepo", "Registering user: ${it.email}")
            saveToDatabase(it)
        }.let { user ->
            // Null safety check and transformation
            if (isValidUser(user)) user else null
        }
    }
}
