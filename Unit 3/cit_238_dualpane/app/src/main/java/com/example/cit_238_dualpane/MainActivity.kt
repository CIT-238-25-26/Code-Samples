package com.example.cit_238_dualpane

import android.content.Intent
import android.os.Bundle
import android.view.View
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
    var isDualPane: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
//        Boolean to check if the app is in dual pane mode (i.e., if the detail fragment is present)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        Check if the element is present in the layout
        isDualPane = findViewById<View>(R.id.star_sign_detail) != null
    }

    override fun onSelected(id: Int) {
//       When a star sign is selected, this method is called. It checks if the app is in dual pane mode.
//       If it is, it updates the detail fragment with the selected star sign data.
//       If not, it starts a new activity to show the details of the selected star sign.
        if (isDualPane) {
            val detailFragment = supportFragmentManager
                .findFragmentById(R.id.star_sign_detail) as DetailFragment
            detailFragment.setStarSignData(id)
        } else {
            val detailIntent = Intent(this, DetailActivity::class.java)
                .apply {
                    putExtra(com.example.cit_238_dualpane.STAR_SIGN_ID, id)
                }
            startActivity(detailIntent)
        }
    }
}