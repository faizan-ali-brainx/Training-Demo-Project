package com.example.trainingdemoapp.network

import com.example.trainingdemoapp.models.UserModel
import com.example.trainingdemoapp.utils.ApiUrls.SIGN_IN
import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @POST(SIGN_IN)
    suspend fun signIn(
        @Body userModel: UserModel
    ): Response<UserModel>

}