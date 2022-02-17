package com.example.trainingdemoapp.viewModels

import android.content.Context
import com.example.trainingdemoapp.Repository
import com.example.trainingdemoapp.base.BaseViewModel
import com.example.trainingdemoapp.sharedPreference.SharedPreference
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository,
    @ApplicationContext val context: Context,
    private val sharedPreferences: SharedPreference
) : BaseViewModel() {

    // region public properties
    // end region

    // region lifeCycle methods
    // end region

    // region private functions
    // end region

    // region public functions
    // end region

}