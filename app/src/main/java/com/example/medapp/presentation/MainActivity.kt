package com.example.medapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.medapp.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navController = findNavController(R.id.navHostFragment)
        val appConfig = AppBarConfiguration(setOf(
            R.id.mainFragment,
            R.id.messagesFragment,
            R.id.myHealthFragment,
            R.id.notificationFragment,
            R.id.profileFragment
        ))
        bottomNavigationView = findViewById(R.id.mainNavigationMenu)
        bottomNavigationView.setupWithNavController(navController)
        //setupActionBarWithNavController(navController, appConfig)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}
