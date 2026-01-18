// Classes definitions can be declared with multiple lines
data class Address(
    val street: String, 
    val city: String
)

// or in a single line
data class Person(val name: String, val address: Address?)

fun main(){
    val person: Person? = Person("Juan", null)

    // Chaining safe calls
    val city = person?.address?.city
    println(city) // Output: null

    // Using let for null checks
    person?.address?.let {
        println("Lives in ${it.city} on ${it.street}")
    } ?: println("Address not available")
}