package com.example.trainingdemoapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.example.trainingdemoapp.R
import com.example.trainingdemoapp.extensions.startExtActivity
import com.example.trainingdemoapp.utils.Constants.SPLASH_DELAY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        checkAndroidVersion()
        setContentView(R.layout.activity_splash)
    }

    private fun checkAndroidVersion() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S) {
            installSplashScreen()
            startExtActivity(MainActivity::class.java)
        } else {
            lifecycleScope.launch(Dispatchers.Main) {
                delay(SPLASH_DELAY)
                startExtActivity(MainActivity::class.java)
            }
        }
    }
}