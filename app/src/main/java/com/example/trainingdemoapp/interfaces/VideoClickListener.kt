package com.example.trainingdemoapp.interfaces

import com.example.trainingdemoapp.models.VideosModel

interface VideoClickListener {
    fun onVideoItemClicked(video: VideosModel)
}