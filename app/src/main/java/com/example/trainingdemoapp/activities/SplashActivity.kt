package com.example.trainingdemoapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.trainingdemoapp.R
import com.example.trainingdemoapp.extensions.startExtActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(R.layout.activity_splash)
        openNextActivity()
    }

    private fun openNextActivity() {
        startExtActivity(LoginActivity::class.java, isFinish = true)
    }
}