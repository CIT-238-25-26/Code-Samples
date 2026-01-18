// Lastly, the also function is useful for performing additional operations on an object 
//  within a chain of calls without altering the object itself. 
// It is often used for logging, debugging, or performing side effects.

fun main() {
    // Logging and validation
    val numbers = mutableListOf(1, 2, 3)
        // don't the object
        // it refers to the object, the numbers list
        .also { println("Initial list: $it") }
        // modify the object
        .apply { add(4) }
        .also { println("After adding: $it") }

    // Access user class
    // Android example: Debugging
    val user = createUser()
        .also { Log.d("UserCreation", "Created user: ${it.name}") }
        .also { saveToDatabase(it) }
        .also { notifyObservers(it) }

    // Chain operations with validation
    fun processOrder(order: Order): Order {
        return order
            .also { validateOrder(it) }
            .also { calculateTotal(it) }
            .also { sendConfirmationEmail(it) }
    }
}