package com.fwahyudianto.pawtner

//  Import Library
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.fwahyudianto.pawtner.databinding.ActivityMainBinding

/**
 *  This software, all associated documentation, and all copies are CONFIDENTIAL INFORMATION of Kalpawreksa
 *  https://www.fwahyudianto.id
 *  ® Wahyudianto, Fajar
 *  Email 	: me@fwahyudianto.id
 *
 */

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var isSplashDone = false

    override fun onCreate(savedInstanceState: Bundle?) {
        //  Themes
        //  AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        //  AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

        val splashScreen = installSplashScreen()

        splashScreen.setKeepOnScreenCondition { !isSplashDone }
        super.onCreate(savedInstanceState)

        Handler(Looper.getMainLooper()).postDelayed({
            isSplashDone = true
        }, 2500)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = findNavController(R.id.nav_host_fragment)
        val navView: BottomNavigationView = binding.bottomNavigationView

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_pets,
                R.id.navigation_favorite,
                R.id.navigation_account
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        // Setup FloatingActionButton click
        binding.fab.setOnClickListener {
            navController.navigate(R.id.navigation_mypets)
        }
    }
}