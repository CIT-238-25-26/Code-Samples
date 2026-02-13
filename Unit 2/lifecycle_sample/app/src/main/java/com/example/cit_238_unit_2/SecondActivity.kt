package com.example.cit_238_unit_2

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.second_activity)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        Add function of the button to return the user to the previous activity
        val backButton = findViewById<Button>(R.id.saveBtn)
        backButton.setOnClickListener {
//            Retrieve the text from the text field and pass it back to the previous activity
            val textField = findViewById<android.widget.EditText>(R.id.inputValue)
            val text = textField.text.toString()
            val intent = intent
//            This intent is passed from this activity (SecondActivity)
//            to the previous activity (MainActivity)
            intent.putExtra("text", text)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}