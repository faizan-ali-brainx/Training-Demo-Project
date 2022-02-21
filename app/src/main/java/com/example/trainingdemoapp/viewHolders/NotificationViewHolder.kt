package com.example.trainingdemoapp.viewHolders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.trainingdemoapp.R
import com.example.trainingdemoapp.databinding.NotificationItemLayoutBinding
import com.example.trainingdemoapp.interfaces.NotificationClickListener
import com.example.trainingdemoapp.models.NotificationModel

class NotificationViewHolder(val itemBinding: NotificationItemLayoutBinding) :
    RecyclerView.ViewHolder(itemBinding.root)  {

    fun bind(mPosition: Int, mNotification: NotificationModel, mListener: NotificationClickListener) {
        itemBinding.apply {
            position = mPosition
            notificationModel = mNotification
            listener = mListener
            executePendingBindings()
        }

    }

    companion object {
        fun from(parent: ViewGroup): NotificationViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding: NotificationItemLayoutBinding = DataBindingUtil
                .inflate(
                    layoutInflater, R.layout.notification_item_layout,
                    parent, false
                )
            return NotificationViewHolder(binding)
        }
    }

}