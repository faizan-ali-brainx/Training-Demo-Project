package com.example.trainingdemoapp.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Meta(@SerializedName("current_page") val current_page : Int,
                @SerializedName("total_pages") val total_pages : Int): Parcelable