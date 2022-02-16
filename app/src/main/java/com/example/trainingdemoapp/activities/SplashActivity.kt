package com.example.trainingdemoapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.trainingdemoapp.R
import com.example.trainingdemoapp.base.BaseActivity
import com.example.trainingdemoapp.extensions.startExtActivity
import com.example.trainingdemoapp.sharedPreference.SharedPreference

class SplashActivity : AppCompatActivity() {

    // region private properties
    private lateinit var sharedPreferences: SharedPreference
    // end region

    // region lifecycle methods
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(R.layout.activity_splash)
        openNextScreen()
    }
    // end region

    // region private funtions
    private fun openNextScreen() {
        sharedPreferences = SharedPreference(applicationContext)
        startExtActivity(
            if (sharedPreferences.isUerLogin) MainActivity::class.java else LoginActivity::class.java,
            isFinish = true
        )
    }
    // end region
}