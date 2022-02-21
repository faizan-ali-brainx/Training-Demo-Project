package com.example.trainingdemoapp.models

import android.os.Parcelable
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Tasks(
    @SerializedName("id")
    @Expose var id: Int,
    @SerializedName("text")
    @Expose var text: String,
    @SerializedName("added?")
    @Expose var added: Boolean = false
) : Parcelable
