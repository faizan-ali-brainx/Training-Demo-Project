package com.example.trainingdemoapp.bindingAdapters

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.trainingdemoapp.extensions.capFirstLetter
import com.example.trainingdemoapp.extensions.getDateWithServerTimeStamp
import com.github.marlonlom.utilities.timeago.TimeAgo

@BindingAdapter("capitalizeText")
fun setCapitalizedText(view: TextView, data: String?) {
    view.text = data?.capFirstLetter()
}

@BindingAdapter("time")
fun setTime(view: TextView,  data: String?) {
    try {
        val timeAgo = data?.getDateWithServerTimeStamp()?:return
        view.text = TimeAgo.using(timeAgo.time)
    }catch (ex:Exception){

    }
}