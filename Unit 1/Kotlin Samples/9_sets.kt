// Sets are collections of unique elements.
// They do not maintain any specific order.

fun main(){
    // Read-only set - automatically removes duplicates
    val uniqueIds = setOf(101, 102, 103, 101, 102)
    println(uniqueIds) // Output: [101, 102, 103]

    // Mutable set
    val tags = mutableSetOf("Android", "Kotlin")
    tags.add("Jetpack")
    tags.add("Android") // Won't add duplicate
    println(tags) // Output: [Android, Kotlin, Jetpack]

    // Set operations
    val set1 = setOf(1, 2, 3, 4)
    val set2 = setOf(3, 4, 5, 6)
    val union = set1.union(set2) // [1, 2, 3, 4, 5, 6]
    val intersection = set1.intersect(set2) // [3, 4]
}