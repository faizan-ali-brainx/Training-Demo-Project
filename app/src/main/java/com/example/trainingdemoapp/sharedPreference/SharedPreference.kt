package com.example.trainingdemoapp.sharedPreference

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SharedPreference @Inject constructor(@ApplicationContext val context: Context) {

    enum class SpKeys(val key: String) {
        FILE_NAME("Demo"),
        IS_USER_LOGIN("isUserLogin")
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

}