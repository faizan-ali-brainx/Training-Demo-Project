package com.example.trainingdemoapp

import com.example.trainingdemoapp.network.ResultState
import com.example.trainingdemoapp.helpers.request
import com.example.trainingdemoapp.models.UserModel
import com.example.trainingdemoapp.network.AppException
import com.example.trainingdemoapp.network.SERVICE
import com.example.trainingdemoapp.sharedPreference.SharedPreference
import com.example.trainingdemoapp.utils.ApiConstants.ACCESS_TOKEN
import com.example.trainingdemoapp.utils.ApiConstants.CLIENT
import com.example.trainingdemoapp.utils.ApiConstants.UID
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(private val sharedPreference: SharedPreference) {

    suspend fun signIn(
        userModel: UserModel,
        data: (UserModel?) -> Unit,
        error: (AppException) -> Unit
    ) {
        request({
            SERVICE.signIn(userModel)
        }, { result, headers ->
            when (result) {
                is ResultState.Success -> {
                    sharedPreference.apply {
                        tokenStore = headers?.get(ACCESS_TOKEN).toString()
                        uidStore = headers?.get(UID).toString()
                        clientStore = headers?.get(CLIENT).toString()
                        userData = result.data
                    }
                    data(result.data)
                }
                is ResultState.Error -> {
                    error(result.error)
                }
            }
        })
    }
}