data class Product(
    val name: String, 
    val price: Double,
     val quantity: Int
)

fun main() {
    val product = Product("Laptop", 25000.0, 5)

    // Destructuring
    val (productName, productPrice, productQuantity) = product
    println("$productName costs ₱$productPrice with $productQuantity in stock")
}