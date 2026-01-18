// Traditional approach vs Lambda approach
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        val button = findViewById<Button>(R.id.myButton)
        
        // Using lambda for click listener
        button.setOnClickListener {
            Toast.makeText(this, "Button clicked!", Toast.LENGTH_SHORT).show()
        }
        
        // Multiple operations in lambda
        button.setOnLongClickListener {
            Log.d("MainActivity", "Long click detected")
            showDialog()
            true // Return value
        }
    }
}
