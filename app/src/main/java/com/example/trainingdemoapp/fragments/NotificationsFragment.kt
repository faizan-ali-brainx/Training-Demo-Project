package com.example.trainingdemoapp.fragments

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trainingdemoapp.activities.MainActivity
import com.example.trainingdemoapp.adpaters.NotificationAdapter
import com.example.trainingdemoapp.base.BaseFragment
import com.example.trainingdemoapp.databinding.FragmentNotificationsBinding
import com.example.trainingdemoapp.interfaces.NotificationClickListener
import com.example.trainingdemoapp.models.NotificationModel
import com.example.trainingdemoapp.utils.Constants.ONE
import com.example.trainingdemoapp.viewModels.NotificationsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotificationsFragment : BaseFragment<NotificationsViewModel, FragmentNotificationsBinding>(), NotificationClickListener {

    // region private properties
    private var notificationList = ArrayList<NotificationModel>()
    private lateinit var requiredActivity: MainActivity
    private lateinit var notificationsAdapter: NotificationAdapter
    // end region

    // region public properties
    // end region

    // region lifeCycle methods
    override val mViewModel: NotificationsViewModel by viewModels()

    override fun getViewBinding() = FragmentNotificationsBinding.inflate(layoutInflater)

    override fun customOnViewCreated(savedInstanceState: Bundle?) {
        setViewModelObserver()
        setNotificationRecyclerview()
        setNotificationsObserver()
        mViewModel.getNotifications(ONE)
    }
    // end region

    // region private functions
    private fun setViewModelObserver() {
        mViewModel.apply {
            vmLoadingObserver.observe(requireActivity(), getLoadingObserver())
            vmMessageObserver.observe(requireActivity(), getErrorObserver())
        }
    }

    private fun setNotificationsObserver() {
        mViewModel.notifications.observe(this) {
            if (!it.notifications.isNullOrEmpty()) {
                notificationsAdapter.apply {
                    setlist(it.notifications)
                    notifyDataSetChanged()
                }
            }
        }
    }

    private fun setNotificationRecyclerview() {
        mViewBinding.notificationRecyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            notificationsAdapter = NotificationAdapter(this@NotificationsFragment)
            adapter = notificationsAdapter
        }
    }

    override fun onNotificationItemClicked(notification: NotificationModel) {

    }
    // end region

    // region public functions
    // end region

    // region listeners
    // end region

}