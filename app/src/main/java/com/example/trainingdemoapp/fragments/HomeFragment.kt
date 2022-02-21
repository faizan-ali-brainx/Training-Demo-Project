package com.example.trainingdemoapp.fragments

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.example.trainingdemoapp.base.BaseFragment
import com.example.trainingdemoapp.databinding.FragmentHomeBinding
import com.example.trainingdemoapp.viewModels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<MainViewModel, FragmentHomeBinding>() {

    // region private properties
    // end region

    // region lifeCycle methods
    override val mViewModel: MainViewModel by viewModels()

    override fun getViewBinding() = FragmentHomeBinding.inflate(layoutInflater)

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