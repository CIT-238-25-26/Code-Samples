package com.example.cit_238_jetpack

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

// Interface and constant for communicating between fragments and activities
const val STAR_SIGN_ID = "STAR_SIGN_ID"
interface StarSignListener {
    fun onSelected(id: Int)
}

class MainActivity : AppCompatActivity(), StarSignListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

//    This method is here (from the interface) because we've implemented the StarSignListener interface, but it's not yet implemented because we haven't set up the fragments and their communication yet.
//    Once we have the fragments in place, this method will be called when a star sign is selected, and we'll implement the logic to either
//    update the detail fragment or start a new activity based on whether we're in dual pane mode or not.
    override fun onSelected(id: Int) {
        TODO("Not yet implemented")
    }
}