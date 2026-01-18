// Function that accepts lambda as parameter
fun performOperation(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    return operation(a, b)
}

// Using the higher-order function
val result1 = performOperation(10, 5) { x, y -> x + y } // 15
val result2 = performOperation(10, 5) { x, y -> x * y } // 50

// Function that returns a function
fun makeMultiplier(factor: Int): (Int) -> Int {
    return { number -> number * factor }
}

val doubler = makeMultiplier(2)
println(doubler(5)) // Output: 10
