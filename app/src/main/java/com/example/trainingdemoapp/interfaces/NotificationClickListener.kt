package com.example.trainingdemoapp.interfaces

import com.example.trainingdemoapp.models.NotificationModel

interface NotificationClickListener {
    fun onNotificationItemClicked(notification: NotificationModel)
}