package com.example.cit_238_tab_nav

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

//        Get the view pager and adapter
//        establish the connection between the view pager and the tab layout
        val viewPage = findViewById<ViewPager2>(R.id.view_pager)
        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)

//        Setting up the adapter for the view pager
        val adapter = MoviesGenresAdapter(supportFragmentManager, lifecycle)
        viewPage.adapter = adapter

        TabLayoutMediator(tabLayout, viewPage) { tab, position ->
//            Retrieve the views from the list of genres and set the text for each tab
//            Uncomment if you want a fixed menu
//            tab.text = getString(TAB_GENRES_FIXED[position])
//            Uncomment if you want a scrollable menu
            tab.text = getString(TAB_GENRES_SCROLLABLE[position])
        }.attach()
    }
}