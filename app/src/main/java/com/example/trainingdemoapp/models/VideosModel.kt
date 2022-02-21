package com.example.trainingdemoapp.models

import android.os.Parcelable
import androidx.databinding.ObservableField
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class VideosModel(
    @SerializedName("title") var title : String,
    @SerializedName("video_url") var video_url : String,
    @SerializedName("description") var description : String,
    @SerializedName("thumbnail_url") var thumbnailUrl : String?,
    @SerializedName("tasks") var tasks : List<Tasks>,
    @SerializedName("filtered_title") var filteredTitle : String?,
    @SerializedName("filtered_description") var filteredDescription : String?,
    var index : Int = -1,
    var isTipsVideo: Boolean = false
): Parcelable {
    var isImageLoading: ObservableField<Boolean> = ObservableField(false)
}