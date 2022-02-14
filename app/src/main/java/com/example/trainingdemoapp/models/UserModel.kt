package com.example.trainingdemoapp.models

import android.os.Parcelable
import androidx.databinding.ObservableField
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class UserModel(
    @SerializedName("id")
    @Expose
    var id: Int? = 0,

    @SerializedName("name")
    @Expose
    var name: String? = null,

    @SerializedName("uid")
    @Expose
    var uid: String? = null,

    @SerializedName("email")
    @Expose
    var email: String? = null,

    @SerializedName("password")
    @Expose
    var password: String? = null,

    @SerializedName("device_token")
    @Expose
    var device_token: String? = null,

    @SerializedName("app_platform")
    @Expose
    var app_platform: String? = null,

    @SerializedName("app_version")
    @Expose
    var app_version: String? = null,

    @SerializedName("active?")
    @Expose
    var active: Boolean? = false,

    @SerializedName("first_login?")
    @Expose
    var first_login: Boolean? = false,
    @SerializedName("office")
    @Expose
    var office: Office? = null,

    @SerializedName("manager")
    @Expose
    var manager: Manager? = null,

    @SerializedName("current_plan")
    @Expose
    var currentPlan: CoachingPlanModel? = null,

    @SerializedName("plans")
    @Expose
    var plans: MutableList<CoachingPlanModel>? = null,

    @SerializedName("can_update_progress?")
    @Expose
    var can_update_progress: Boolean? = false,

    @SerializedName("coach")
    @Expose
    var coach: Coach? = null
) : Serializable

data class Coach(
    @SerializedName("name")
    @Expose
    var name: String? = null
) : Serializable

data class Manager(
    @SerializedName("name")
    @Expose
    var name: String? = null
) : Serializable

data  class Office(
    @SerializedName("name")
    @Expose
    var name: String? = null,

    @SerializedName("address")
    @Expose
    var address: String? = null
) : Serializable

data class CoachingPlanModel (

    @SerializedName("id")
    @Expose
    var id: Int? = null,

    @SerializedName("name")
    @Expose
    var name: String? = null,

    @SerializedName("started_at")
    @Expose
    val startedAt: String?=null,

    @SerializedName("current_plan?")
    @Expose
    var currentPlan: Boolean?=null,
    var index: Int = -1
): Serializable
