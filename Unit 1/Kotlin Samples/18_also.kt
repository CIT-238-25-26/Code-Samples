// Logging and validation
val numbers = mutableListOf(1, 2, 3)
    .also { println("Initial list: $it") }
    .apply { add(4) }
    .also { println("After adding: $it") }

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
