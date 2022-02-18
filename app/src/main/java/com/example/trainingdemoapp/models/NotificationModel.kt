package com.example.trainingdemoapp.models

import android.os.Parcelable
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NotificationModel(
    @SerializedName("id")
    @Expose var id : Int,
    @SerializedName("title")
    @Expose var title : String,
    @SerializedName("description")
    @Expose var description : String,
    @SerializedName("created_at")
    @Expose var created_at : String,
    @SerializedName("seen?")
    @Expose var seen : Boolean = false,
    @SerializedName("sent_by_name")
    @Expose var sent_by_name : String?,
    @SerializedName("sent_by_role")
    @Expose var sent_by_role : String?,
    @SerializedName("announcement_type")
    @Expose var announcement_type : String,
    @SerializedName("goal_congratulation")
    @Expose val goalCongratulation : GoalCongratulation?


): Parcelable {

    var pId: ObservableInt = ObservableInt(id)
    var pTitle: ObservableField<String> = ObservableField(title)
    var pDescription: ObservableField<String> = ObservableField(description)
    var pCreatedAt: ObservableField<String> = ObservableField(created_at)
    var pSeen: ObservableField<Boolean> = ObservableField(seen)

}
@Parcelize
data class GoalCongratulation (
    @SerializedName("id") val id : Int,
    @SerializedName("achieved_value") val achievedValue : Double,
    @SerializedName("achieved_value_type") val achievedValueType : String,
    @SerializedName("seen?") val seen : Boolean,
) : Parcelable