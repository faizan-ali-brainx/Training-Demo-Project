package com.example.trainingdemoapp.models

import com.google.gson.annotations.SerializedName

data class TipsVideos(
    @SerializedName("tips") val tips : List<VideosModel>,
    @SerializedName("meta") val meta : Meta)