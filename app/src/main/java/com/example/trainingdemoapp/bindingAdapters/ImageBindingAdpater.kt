package com.example.trainingdemoapp.bindingAdapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.trainingdemoapp.extensions.loadImageFromInternetGlide
import com.example.trainingdemoapp.extensions.loadNoImageAvailable
import com.example.trainingdemoapp.models.VideosModel

@BindingAdapter("backgroundImageUrl")
fun loadBackgroundImage(view: ImageView, data: Any?) {
    data?.apply {
        if (this is VideosModel) {
            if (thumbnailUrl != null) {
                loadImageFromInternetGlide(view, thumbnailUrl, isImageLoading)
            } else {
                loadNoImageAvailable(view, isImageLoading)
            }
        }
    }
}