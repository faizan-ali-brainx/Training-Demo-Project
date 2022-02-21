package com.example.trainingdemoapp.network

import com.example.trainingdemoapp.models.NotificationsResponse
import com.example.trainingdemoapp.models.TipsVideos
import com.example.trainingdemoapp.models.UserModel
import com.example.trainingdemoapp.utils.ApiConstants.ACCESS_TOKEN
import com.example.trainingdemoapp.utils.ApiConstants.CLIENT
import com.example.trainingdemoapp.utils.ApiConstants.UID
import com.example.trainingdemoapp.utils.ApiUrls.NOTIFICATIONS
import com.example.trainingdemoapp.utils.ApiUrls.SIGN_IN
import com.example.trainingdemoapp.utils.ApiUrls.TIPS
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @POST(SIGN_IN)
    suspend fun signIn(
        @Body userModel: UserModel
    ): Response<UserModel>

    @GET(TIPS)
    suspend fun tipsVideos(
        @Header(ACCESS_TOKEN) token: String,
        @Header(UID) uid: String,
        @Header(CLIENT) client: String,
        @Query("page") page: Int
    ): Response<TipsVideos>

    @GET(NOTIFICATIONS)
    suspend fun getNotifications(
        @Header(ACCESS_TOKEN) token: String,
        @Header(UID) uid: String,
        @Header(CLIENT) client: String,
        @Query("page") page: Int
    ): Response<NotificationsResponse>

}