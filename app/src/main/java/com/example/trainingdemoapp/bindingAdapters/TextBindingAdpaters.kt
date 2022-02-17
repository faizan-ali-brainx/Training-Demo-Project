package com.example.trainingdemoapp.bindingAdapters

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.trainingdemoapp.extensions.capFirstLetter

@BindingAdapter("capitalizeText")
fun setCapitalizedText(view: TextView, data: String?) {
    view.text = data?.capFirstLetter()
}