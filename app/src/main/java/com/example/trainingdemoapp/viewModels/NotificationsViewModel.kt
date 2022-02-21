package com.example.trainingdemoapp.viewModels

import android.content.Context
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.trainingdemoapp.Repository
import com.example.trainingdemoapp.base.BaseViewModel
import com.example.trainingdemoapp.models.NotificationsResponse
import com.example.trainingdemoapp.models.NotificationModel
import com.example.trainingdemoapp.sharedPreference.SharedPreference
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotificationsViewModel @Inject constructor(
    private val repository: Repository,
    @ApplicationContext val context: Context,
    private val sharedPreferences: SharedPreference
) : BaseViewModel() {

    // region public properties
    var notifications = MutableLiveData<NotificationsResponse>()
    var notificationModel = ObservableField<NotificationModel>()
    // end region

    // region lifeCycle methods
    // end region

    // region private functions
    // end region

    // region public functions
    fun getNotifications(page: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getNotifications(page, {
                if (it != null)
                    notifications.postValue(it)
            }, {
                showToast(it.errorMsg)
            })
        }
    }
    // end region

}