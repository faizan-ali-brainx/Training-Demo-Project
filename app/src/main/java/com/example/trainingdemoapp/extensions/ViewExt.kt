package com.example.trainingdemoapp.extensions

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.trainingdemoapp.base.BaseApp

fun View.beInvisibleIf(beInvisible: Boolean) = if (beInvisible) beInvisible() else beVisible()

fun View.beVisibleIf(beVisible: Boolean) = if (beVisible) beVisible() else beGone()

fun View.beGoneIf(beGone: Boolean) = beVisibleIf(!beGone)

fun View.beInvisible() {
    visibility = View.INVISIBLE
}

fun View.beVisible() {
    visibility = View.VISIBLE
}

fun View.beGone() {
    visibility = View.GONE
}

fun ImageView.setCustomImageDrawable(drawable: Int) {
    this.setImageDrawable(ContextCompat.getDrawable(BaseApp.getTmContext(), drawable))
}

fun View.setCustomBackGroundColor(color: Int) {
    this.setBackgroundColor(ContextCompat.getColor(BaseApp.getTmContext(), color))
}

fun TextView.setCustomTextColor(color: Int) {
    this.setTextColor(ContextCompat.getColor(BaseApp.getTmContext(), color))
}