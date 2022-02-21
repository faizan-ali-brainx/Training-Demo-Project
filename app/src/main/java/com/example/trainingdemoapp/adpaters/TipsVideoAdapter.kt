package com.example.trainingdemoapp.adpaters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.trainingdemoapp.interfaces.VideoClickListener
import com.example.trainingdemoapp.models.VideosModel
import com.example.trainingdemoapp.viewHolders.VideoViewHolder

class TipsVideoAdapter(
    private val mListener: VideoClickListener
): RecyclerView.Adapter<VideoViewHolder>() {

    var videoList: ArrayList<VideosModel> = ArrayList()

    fun setData(data: List<VideosModel>) {
        videoList.apply {
            clear()
            addAll(data)
        }
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder =
        VideoViewHolder.from(parent)

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) =
        holder.bind(position, this.videoList[position], mListener)

    override fun getItemCount(): Int {
        return this.videoList.size
    }
}