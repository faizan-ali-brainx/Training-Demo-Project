package com.example.trainingdemoapp.adpaters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.trainingdemoapp.interfaces.NotificationClickListener
import com.example.trainingdemoapp.models.NotificationModel
import com.example.trainingdemoapp.viewHolders.NotificationViewHolder

class NotificationAdapter(
    private val mListener: NotificationClickListener
): RecyclerView.Adapter<NotificationViewHolder>() {

    private var notificationList: MutableList<NotificationModel> = mutableListOf()

    fun setlist(list: List<NotificationModel>) {
        notificationList.apply {
            clear()
            addAll(list)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder =
        NotificationViewHolder.from(parent)

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) = holder.bind(position,
        notificationList[position], mListener)

    override fun getItemCount(): Int {
        return notificationList.size
    }
}