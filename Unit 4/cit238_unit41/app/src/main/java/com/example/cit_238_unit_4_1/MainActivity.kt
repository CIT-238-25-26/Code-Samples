package com.example.cit_238_unit_4_1

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var appBarConfiguration_bottom: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
//        Attach the action bar to the window
        setSupportActionBar(findViewById(R.id.toolbar))

//      Manages the fragments to be displayed by the nav controller
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

// SETUP for the Drawer Menu
//    Creating top level destinations and adding them to the draw
        appBarConfiguration = AppBarConfiguration(
            setOf(
//                List the
                R.id.nav_home, R.id.nav_recent, R.id.nav_favorites, R.id.nav_archive, R.id.nav_bin
            ), findViewById(R.id.drawer_layout)
        )
        setupActionBarWithNavController(navController,
            appBarConfiguration)
        findViewById<NavigationView>(R.id.nav_view_drawer)?.setupWithNavController(navController)

//  SETUP for the Bottom Navigation Menu
//Creating top level destinations
//and adding them to bottom navigation
        appBarConfiguration_bottom = AppBarConfiguration(setOf(
            R.id.nav_home, R.id.nav_tickets, R.id.nav_offers, R.id.nav_rewards))
        setupActionBarWithNavController(navController,
            appBarConfiguration)
        findViewById<BottomNavigationView>(R.id.nav_view_bottom)
            ?.setupWithNavController(navController)
    }

    //    extended function, specifies the item within the navigation drawer that should be highlighted when the user
    //    clicks on it
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        Inflate the created menu
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

//    This functions handles the click events for the menu items
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        Automatically assigns the item to the nav controller
//        Gives functionality to the menu items
        return item.onNavDestinationSelected(findNavController(R.id.nav_host_fragment))
    }

}