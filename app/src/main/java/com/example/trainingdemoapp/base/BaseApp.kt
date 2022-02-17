package com.example.trainingdemoapp.base

import android.app.Application
import android.content.Context
import com.example.trainingdemoapp.BuildConfig
import com.example.trainingdemoapp.network.NetworkApi
import com.example.trainingdemoapp.sharedPreference.SharedPreference
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BaseApp : Application() {

    // region companion object
    companion object {
        private lateinit var appInstance: BaseApp
        fun getApplication(): BaseApp = appInstance
        fun getTmContext(): Context = appInstance.applicationContext
    }
    // end region

    //region LifeCycle
    override fun onCreate() {
        appInstance = this
        super.onCreate()
        NetworkApi.setBaseUrl(BuildConfig.BASE_URL)
        SharedPreference(getTmContext()).apply {
            NetworkApi.headerMap = hashMapOf(
                "Content-Type" to "application/json",
                "app-platform" to "android",
                "app-version" to BuildConfig.VERSION_NAME,
                "access-token" to tokenStore.toString(),
                "client" to clientStore.toString(),
                "uid" to uidStore.toString()
            )
        }
    }
    //endregion


}