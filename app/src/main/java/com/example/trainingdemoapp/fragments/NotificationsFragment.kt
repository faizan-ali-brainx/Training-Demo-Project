package com.example.trainingdemoapp.fragments

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.example.trainingdemoapp.base.BaseFragment
import com.example.trainingdemoapp.databinding.FragmentNotificationsBinding
import com.example.trainingdemoapp.viewModels.NotificationsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotificationsFragment : BaseFragment<NotificationsViewModel, FragmentNotificationsBinding>() {

    // region private properties
    // end region

    // region public properties
    // end region

    // region lifeCycle methods
    override val mViewModel: NotificationsViewModel by viewModels()

    override fun getViewBinding() = FragmentNotificationsBinding.inflate(layoutInflater)

    override fun customOnViewCreated(savedInstanceState: Bundle?) {

    }
    // end region

    // region private functions
    // end region

    // region public functions
    // end region

    // region listeners
    // end region

}