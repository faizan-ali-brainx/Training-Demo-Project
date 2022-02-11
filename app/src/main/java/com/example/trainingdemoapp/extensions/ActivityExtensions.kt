package com.example.trainingdemoapp.extensions

import android.app.Activity
import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.widget.Toast

fun <T> Activity.startExtActivity(
    activityClass: Class<T>,
    activityOption: ActivityOptions? = null,
    isFinishAffinity: Boolean = false,
    isFinish: Boolean = false,
    intent: Intent? = null,
    bundle: Bundle? = null,
) {
    val newIntent = intent ?: Intent(this@startExtActivity, activityClass)
    bundle?.apply { newIntent.putExtras(bundle) }

    activityOption?.apply {
        startActivity(newIntent, toBundle())
    } ?: run {
        startActivity(newIntent)
    }
    if (isFinishAffinity) finishAffinity()
    if (isFinish && !isFinishAffinity) finish()
}

fun Activity.showToast(message: Any?) {
    val messageString = when (message) {
        is String -> message
        is Int -> getString(message)
        else -> null
    }
    if (messageString.isNullOrEmpty()) return
    try {
        Toast.makeText(this, messageString, Toast.LENGTH_SHORT).show()
    } catch (e: Exception) {
    }
}