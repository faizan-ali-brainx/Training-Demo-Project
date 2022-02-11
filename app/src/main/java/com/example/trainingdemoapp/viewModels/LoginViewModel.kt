package com.example.trainingdemoapp.viewModels

import android.content.Context
import android.content.SharedPreferences
import android.view.View
import androidx.lifecycle.MutableLiveData
import com.example.trainingdemoapp.Repository
import com.example.trainingdemoapp.base.BaseViewModel
import com.example.trainingdemoapp.sharedPreference.SharedPreference
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: Repository,
    @ApplicationContext val context: Context,
    private val sharedPreferences: SharedPreference
) : BaseViewModel() {

    // region public properties
    var email = MutableLiveData<String>()
    var password = MutableLiveData<String>()
    var logInObserver = MutableLiveData<Boolean>()
    // end region

    // region public functions

    fun onLoginClick(view: View) {

    }
    // end region

    // region private funtions

    // end region
}