// Lambda expression syntax
val sum = { a: Int, b: Int -> a + b }
println(sum(5, 3)) // Output: 8

// Lambda with single parameter (implicit 'it')
val square: (Int) -> Int = { it * it }
println(square(4)) // Output: 16

// Multi-line lambda
val calculate = { x: Int, y: Int ->
    val result = x * y
    println("Calculating...")
    result // Last expression is returned
}
