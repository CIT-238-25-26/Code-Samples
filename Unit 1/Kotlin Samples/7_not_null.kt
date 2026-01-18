// Use with caution - throws NPE if null
fun main() {
    val certainlyNotNull: String? = "Kotlin"

    val length = certainlyNotNull!!.length // Throws NPE if null

    // Better approach: Check before using
    if (certainlyNotNull != null) {
        val safeLength = certainlyNotNull.length
    }
}