// Non-nullable type - cannot hold null
// One of the key features of Kotlin is its null safety
// This was implemented on other programming languages, such as Dart

// Here we have declared the variable as var, instead of val 
// This is to allow reassignment

// val in Kotlin means the variable is read-only (like final in Java)
// var means the variable is mutable

fun main() {
    var name: String = "Android Developer"
    // name = null // Compilation error!

    // Nullable type - can hold null
    var nullableName: String? = "Kotlin"
    nullableName = null // Valid

    // Safe call operator (?.)
    val length = nullableName?.length // Returns null if nullableName is null
    println(length) // Output: null
}