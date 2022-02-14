package com.example.trainingdemoapp.viewModels

import android.content.Context
import androidx.fragment.app.Fragment
import com.example.trainingdemoapp.R
import com.example.trainingdemoapp.Repository
import com.example.trainingdemoapp.base.BaseViewModel
import com.example.trainingdemoapp.fragments.HomeFragment
import com.example.trainingdemoapp.fragments.NotificationsFragment
import com.example.trainingdemoapp.fragments.SettingsFragment
import com.example.trainingdemoapp.sharedPreference.SharedPreference
import com.example.trainingdemoapp.utils.Constants.BOTTOM_NAV_ITEM_HOME
import com.example.trainingdemoapp.utils.Constants.BOTTOM_NAV_ITEM_NOTIFICATIONS
import com.example.trainingdemoapp.utils.Constants.BOTTOM_NAV_ITEM_SETTINGS
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