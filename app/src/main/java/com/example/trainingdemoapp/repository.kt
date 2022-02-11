package com.example.trainingdemoapp

import com.example.trainingdemoapp.network.ResultState
import com.example.trainingdemoapp.helpers.request
import com.example.trainingdemoapp.network.SERVICE
import com.example.trainingdemoapp.sharedPreference.SharedPreference
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(private val sharedPreference: SharedPreference) {

    suspend fun checkApiCall() {
        request({
            SERVICE.checkApiCallWorking()
        }, { result, _ ->
            when (result) {
                is ResultState.Success -> {

                }
                is ResultState.Error -> {

                }
            }
        })
    }
}