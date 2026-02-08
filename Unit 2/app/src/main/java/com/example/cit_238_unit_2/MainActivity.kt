package com.example.cit_238_unit_2

import android.app.ComponentCaller
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

//    Store the states in strings
    var prevState = ""
    var curState = ""

//    The purpose of this project is to show/demonstrate students
//    the life cycles present in an Android application

//    Commonly used Life Cycle
//    Most of the functions such as loading the UI, setting up listeners, and initializing data are typically done in the onCreate() method.
//    This is where you set up your activity's user interface and prepare it for user interaction.
    override fun onCreate(savedInstanceState: Bundle?) {
        println("onCreate called")
            super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        updateUIText("ONCREATE")

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val nextButton = findViewById<Button>(R.id.nextPageBtn)
        nextButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
//            Use this method to start an activity only
//            startActivity(intent)
//            If you are expecting a result back from the activity you are starting, you can use startActivityForResult() instead of startActivity().
            startActivityForResult(intent, 1)

        }
    }

//    onStart() - Called when the activity is becoming visible to the user.
//    Prepare the UI and resources that are needed while the activity is visible.
    override fun onStart() {
        println("onStart called")
        updateUIText("ONSTART")
        super.onStart()
    }

//    onResume() - Called when the activity starts interacting with the user.
//    Resume animations, audio, and other resources that were paused/stopped in onPause().
    override fun onResume() {
        println("onResume called")
        updateUIText("ONRESUME")
        super.onResume()
    }

//    onPause() - Called when the activity loses focus but is still partially visible.
//    Save data and pause resource-intensive operations (animations, sensors, GPS).
    override fun onPause() {
        println("onPause called")
        updateUIText("ONPAUSE")
        super.onPause()
    }

//    onStop() - Called when the activity is no longer visible to the user.
//    It's safe to release most resources, but keep lightweight data persistence.
    override fun onStop() {
        println("onStop called")
        updateUIText("ONSTOP")
        super.onStop()
    }

//    onDestroy() - Called when the activity is being destroyed.
//    Clean up any remaining resources, listeners, or database connections.
    override fun onDestroy() {
        println("onDestroy called")
        updateUIText("ONDESTROY")
        super.onDestroy()
    }

//    onRestart() - Called when a stopped activity is about to start again.
//    Used to refresh state that may have changed while the activity was stopped.
    override fun onRestart() {
        println("onRestart called")
        updateUIText("ONRESTART")
        super.onRestart()
    }

// Function to update the UI text
fun updateUIText(newState: String) {
    prevState = curState
    curState = newState

    val prevStateView = findViewById<TextView>(R.id.prevStateValue)
    val curStateView = findViewById<TextView>(R.id.curStateValue)
    prevStateView.text = prevState
    curStateView.text = curState
}

//    Triggered when an activity you started with startActivityForResult() finishes and returns a result.
    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?,
        caller: ComponentCaller
    ) {
        super.onActivityResult(requestCode, resultCode, data, caller)
        println("onActivityResult called")

//        Result codes are similar to your API response codes, where you can have a success code (RESULT_OK) or an error code (RESULT_CANCELED).
        println("requestCode: $requestCode, resultCode: $resultCode")
        if (requestCode == 1 && resultCode == RESULT_OK) {
            val text = data?.getStringExtra("text")
            val resultTextView = findViewById<TextView>(R.id.returnedValue)
            resultTextView.text = "Received value: $text"
        }
    }

//    This one will be triggered when the system is about to destroy the activity to save its current state,
//    such as during a configuration change (like screen rotation) or when the activity is being put into the background and may be

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
    }

}