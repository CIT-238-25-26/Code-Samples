data class Config(
    var apiUrl: String = "",
    var timeout: Int = 0,
    var enableLogging: Boolean = false
)

fun main() {
    // let - returns lambda result, uses 'it'
    val result = Config().let {
        it.apiUrl = "https://api.example.com"
        it.timeout = 30
        "Configuration complete" // Returns this string
    }

    // apply - returns the object, uses 'this'
    val config = Config().apply {
        apiUrl = "https://api.example.com"
        timeout = 30
        enableLogging = true
    } // Returns Config object

    // also - returns the object, uses 'it'
    val validatedConfig = Config().also {
        it.apiUrl = "https://api.example.com"
        println("Config created: $it")
    } // Returns Config object

}