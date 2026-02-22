package com.example.cit_238_dualpane

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val starSignId = intent.extras?.getInt(STAR_SIGN_ID, 0) ?: 0
        val detailFragment = supportFragmentManager .findFragmentById(R.id.star_sign_detail) as DetailFragment
        detailFragment.setStarSignData(starSignId)
    }
}