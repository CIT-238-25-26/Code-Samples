// From the Collections section,
// List are said to contain ordered elements that can be accessed by their index.
// Also, duplicate elements are allowed in lists.

fun main() {
    // Read-only list
    val fruits = listOf("Apple", "Banana", "Orange", "Apple")
    println(fruits[0]) // Output: Apple
    println(fruits.size) // Output: 4

    // Mutable list
    val shoppingCart = mutableListOf("Laptop", "Mouse")
    shoppingCart.add("Keyboard")
    shoppingCart.remove("Mouse")
    println(shoppingCart) // Output: [Laptop, Keyboard]

    // Common list operations
    val numbers = listOf(1, 2, 3, 4, 5)
    val doubled = numbers.map { it * 2 } // [2, 4, 6, 8, 10]
    val evens = numbers.filter { it % 2 == 0 } // [2, 4]
}