package com.example.trainingdemoapp.base

import android.app.Application
import android.content.Context

class BaseApp : Application() {

    // region companion object
    companion object {
        private lateinit var bApp: BaseApp
        fun getApplication(): BaseApp = bApp
        fun getTmContext(): Context = bApp.applicationContext
    }
    // end region
}