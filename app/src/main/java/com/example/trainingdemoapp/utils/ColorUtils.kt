package com.example.trainingdemoapp.extensions

import android.content.Context
import android.graphics.ColorFilter
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import androidx.core.content.ContextCompat

fun getFilterColor(context: Context, colorId: Int): ColorFilter {
    return PorterDuffColorFilter(
        ContextCompat.getColor(
            context,
            colorId
        ), PorterDuff.Mode.SRC_ATOP
    )
}