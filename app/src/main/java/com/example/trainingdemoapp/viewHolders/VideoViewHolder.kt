package com.example.trainingdemoapp.viewHolders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableField
import androidx.recyclerview.widget.RecyclerView
import com.example.trainingdemoapp.R
import com.example.trainingdemoapp.databinding.TrainingVideoItemLayoutBinding
import com.example.trainingdemoapp.models.VideosModel

class VideoViewHolder(val itemBinding: TrainingVideoItemLayoutBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {
    fun bind(position: Int, mVideo: VideosModel, listener: VideoClickListener) {
        itemBinding.apply {
            mVideo.apply {
                index = position
                isImageLoading = ObservableField(false)
                video = this
            }
            videoItemClick = listener
            executePendingBindings()
        }
    }

    companion object {
        fun from(parent: ViewGroup): VideoViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding: TrainingVideoItemLayoutBinding = DataBindingUtil
                .inflate(
                    layoutInflater, R.layout.training_video_item_layout,
                    parent, false
                )
            return VideoViewHolder(binding)
        }
    }

    interface VideoClickListener {
        fun onVideoItemClicked(video: VideosModel)
    }

}