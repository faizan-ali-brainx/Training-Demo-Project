package com.example.trainingdemoapp.sharedPreference

import android.content.Context
import android.content.SharedPreferences
import com.example.trainingdemoapp.models.UserModel
import com.example.trainingdemoapp.utils.toJson
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SharedPreference @Inject constructor(@ApplicationContext val context: Context) {

    enum class SpKeys(val key: String) {
        FILE_NAME("Demo"),
        IS_USER_LOGIN("isUserLogin"),
        TOKEN("token"),
        UID("uid"),
        CLIENT("client"),
        USER_DATA("user")
    }

    private val preferences =
        context.getSharedPreferences(SpKeys.FILE_NAME.key, Context.MODE_PRIVATE)
    private var editor: SharedPreferences.Editor = preferences.edit()

    fun clearPrefs() {
        editor.clear().apply()
    }

    private fun getSharedPreferenceStringEmptyDefault(key: String): String? {
        return preferences.getString(key, "")
    }

    private fun putSharedPreferenceString(key: String, value: String?) {
        editor.apply {
            putString(key, value)
            apply()
        }
    }

    private fun getSharedPreferenceIntEmptyDefault(key: String): Int {
        return preferences.getInt(key, 0)
    }

    private fun putSharedPreferenceInt(key: String, value: Int) {
        editor.apply {
            putInt(key, value)
            apply()
        }
    }


    var isUerLogin: Boolean
        get() = preferences.getBoolean(SpKeys.IS_USER_LOGIN.key, false)
        set(isUserCreated) {
            editor.apply {
                putBoolean(SpKeys.IS_USER_LOGIN.key, isUserCreated)
                apply()
            }
        }

    var tokenStore: String?
        get() = getSharedPreferenceStringEmptyDefault(SpKeys.TOKEN.key)
        set(token) = putSharedPreferenceString(SpKeys.TOKEN.key, token)

    var uidStore: String?
        get() = getSharedPreferenceStringEmptyDefault(SpKeys.UID.key)
        set(token) = putSharedPreferenceString(SpKeys.UID.key, token)

    var clientStore: String?
        get() = getSharedPreferenceStringEmptyDefault(SpKeys.CLIENT.key)
        set(token) = putSharedPreferenceString(SpKeys.CLIENT.key, token)

    var userData: UserModel?
        get() {
            return Gson().fromJson(
                getSharedPreferenceStringEmptyDefault(SpKeys.USER_DATA.key),
                UserModel::class.java
            )
        }
        set(model) {
            putSharedPreferenceString(SpKeys.USER_DATA.key, model?.toJson())
        }

}