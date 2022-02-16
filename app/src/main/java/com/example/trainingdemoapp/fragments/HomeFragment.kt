package com.example.trainingdemoapp.fragments

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.example.trainingdemoapp.activities.ActivitiesAndTipsActivity
import com.example.trainingdemoapp.base.BaseFragment
import com.example.trainingdemoapp.databinding.FragmentHomeBinding
import com.example.trainingdemoapp.extensions.startExtActivity
import com.example.trainingdemoapp.viewModels.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>() {

    // region private properties
    // end region

    // region lifeCycle methods
    override val mViewModel: HomeViewModel by viewModels()

    override fun getViewBinding() = FragmentHomeBinding.inflate(layoutInflater)

    override fun customOnViewCreated(savedInstanceState: Bundle?) {
        mViewBinding.viewModel = mViewModel
        setClickListeners()
    }
    // end region

    // region private functions
    private fun setClickListeners() {
        mViewBinding.btnActivities.setOnClickListener {
            activity?.startExtActivity(ActivitiesAndTipsActivity::class.java)
        }
    }
    // end region

    // region public functions
    // end region

    // region listeners
    // end region

}