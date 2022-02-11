package com.example.trainingdemoapp.base

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.example.trainingdemoapp.sharedPreference.SharedPreference
import javax.inject.Inject

abstract class BaseFragment<VM : ViewModel, VB : ViewBinding> : Fragment() {

    // region properties
    @Inject
    lateinit var sharedPreference: SharedPreference
    // end region
}