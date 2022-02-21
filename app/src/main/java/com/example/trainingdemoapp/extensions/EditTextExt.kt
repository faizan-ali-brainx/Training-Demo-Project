package com.example.trainingdemoapp.extensions

import android.text.InputType
import android.widget.EditText

fun EditText.enablePasswordVisibility(enable: Boolean) {
    inputType = if (!enable) {
        InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
    } else {
        InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
    }
    setSelection(text.toString().length)
}