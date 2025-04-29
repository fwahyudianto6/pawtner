package com.fwahyudianto.pawtner.ui.started

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.fwahyudianto.pawtner.databinding.ActivityStartedBinding

class StartedActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStartedBinding
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

        binding = ActivityStartedBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.started.setOnClickListener {
//            // TODO: Pergi ke halaman register
//        }
//
//        binding.tvLogin.setOnClickListener {
//            // TODO: Pergi ke halaman login
//        }
    }
}