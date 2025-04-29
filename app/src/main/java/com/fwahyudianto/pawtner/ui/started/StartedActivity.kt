package com.fwahyudianto.pawtner.ui.started

//  Import Library
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.denzcoskun.imageslider.BuildConfig
import com.fwahyudianto.pawtner.databinding.ActivityStartedBinding
import com.fwahyudianto.pawtner.ui.auth.LoginActivity
import com.fwahyudianto.pawtner.ui.auth.RegisterActivity

class StartedActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStartedBinding
    private var isSplashDone = false

    override fun onCreate(savedInstanceState: Bundle?) {
        //  Themes
        //  AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        //  AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

        //  Splashscreen API
        val splashScreen = installSplashScreen()
        splashScreen.setKeepOnScreenCondition { !isSplashDone }

        super.onCreate(savedInstanceState)

        binding = ActivityStartedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler(Looper.getMainLooper()).postDelayed({
            isSplashDone = true
        }, 2500)

        showAppVersion()

        binding.startedBtnStart.setOnClickListener {
            val intRegister = Intent(this, RegisterActivity::class.java)
            startActivity(intRegister)
            finish()
        }

        binding.startedTvSuggest.setOnClickListener {
            val intLogin = Intent(this, LoginActivity::class.java)
            startActivity(intLogin)
        }
    }

    private fun showAppVersion() {
        val appVersion = BuildConfig.VERSION_NAME

        binding.startedTvVersion.text = "Version $appVersion"
        binding.startedTvVersion.alpha = 0f
        binding.startedTvVersion.animate().alpha(1f).setDuration(1000).start()
    }
}