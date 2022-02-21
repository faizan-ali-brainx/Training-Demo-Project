package com.example.trainingdemoapp.models

import com.google.gson.annotations.SerializedName

data class NotificationsResponse(
    @SerializedName("announcements") val notifications: List<NotificationModel>,
    @SerializedName("meta") val meta: Meta
)