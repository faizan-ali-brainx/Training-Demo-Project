package com.example.trainingdemoapp.viewModels

import android.content.Context
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.trainingdemoapp.R
import com.example.trainingdemoapp.Repository
import com.example.trainingdemoapp.base.BaseViewModel
import com.example.trainingdemoapp.extensions.isValidEmail
import com.example.trainingdemoapp.models.UserModel
import com.example.trainingdemoapp.sharedPreference.SharedPreference
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: Repository,
    @ApplicationContext val context: Context,
    private val sharedPreferences: SharedPreference
) : BaseViewModel() {

    // region public properties
    var emailObserver = MutableLiveData<String>()
    var passwordObserver = MutableLiveData<String>()
    var logInObserver = MutableLiveData<Boolean>()
    // end region

    // region private functions
    private fun isValid(): Boolean {
        return when {
            emailObserver.value.isNullOrEmpty() -> {
                showToast(R.string.enter_email)
                false
            }
            emailObserver.value.isValidEmail() == false -> {
                showToast(R.string.inavlid_email)
                false
            }
            passwordObserver.value.isNullOrEmpty() -> {
                showToast(R.string.enter_password)
                false
            }
            else -> true
        }
    }

    private fun getFieldsData(): UserModel {
        return UserModel(
            email = emailObserver.value,
            password = passwordObserver.value
        )
    }
    // end region

    // region public functions
    fun login(v: View) {


//        if (isValid()) {
//            viewModelScope.launch(Dispatchers.IO) {
//                showProcessingLoader()
//                repository.signIn(getFieldsData(), {
//                    hideProcessingLoader()
//                    sharedPreferences.isUerLogin = true
//                    logInObserver.postValue(true)
//                }, {
//                    hideProcessingLoader()
//                    showToast(it.errorMsg)
//                    logInObserver.postValue(false)
//                })
//            }
//        }
    }
    // end region

}