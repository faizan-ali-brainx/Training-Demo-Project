package com.example.trainingdemoapp.fragments

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.example.trainingdemoapp.base.BaseFragment
import com.example.trainingdemoapp.databinding.FragmentActivitiesBinding
import com.example.trainingdemoapp.viewModels.ActivitiesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ActivitiesFragment : BaseFragment<ActivitiesViewModel, FragmentActivitiesBinding>() {

    // region private properties
    // end region

    // region lifeCycle methods
    override val mViewModel: ActivitiesViewModel by viewModels()

    override fun getViewBinding() = FragmentActivitiesBinding.inflate(layoutInflater)

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