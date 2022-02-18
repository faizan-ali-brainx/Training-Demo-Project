package com.example.trainingdemoapp.network

import com.example.trainingdemoapp.models.NotifiactionsResponse
import com.example.trainingdemoapp.models.TipsVideos
import com.example.trainingdemoapp.models.UserModel
import com.example.trainingdemoapp.utils.ApiUrls.NOTIFICATIONS
import com.example.trainingdemoapp.utils.ApiUrls.SIGN_IN
import com.example.trainingdemoapp.utils.ApiUrls.TIPS
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    @POST(SIGN_IN)
    suspend fun signIn(
        @Body userModel: UserModel
    ): Response<UserModel>

    @GET(TIPS)
    suspend fun tipsVideos(
        @Query("page") page: Int
    ): Response<TipsVideos>

    @GET(NOTIFICATIONS)
    suspend fun getNotifications(
        @Query("page") page: Int
    ): Response<NotifiactionsResponse>

}