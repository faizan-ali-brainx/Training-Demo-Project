package com.example.trainingdemoapp.viewModels

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.trainingdemoapp.Repository
import com.example.trainingdemoapp.base.BaseViewModel
import com.example.trainingdemoapp.models.TipsVideos
import com.example.trainingdemoapp.models.VideosModel
import com.example.trainingdemoapp.sharedPreference.SharedPreference
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TipsViewModel @Inject constructor(
    private val repository: Repository,
    @ApplicationContext val context: Context,
    private val sharedPreferences: SharedPreference
) : BaseViewModel() {

    // region public properties
    var tips = MutableLiveData<TipsVideos>()
    var tipsVideosList = MutableLiveData<ArrayList<VideosModel>>()
    // end region

    // region lifeCycle methods
    // end region

    // region private functions
    // end region

    // region public functions
    fun getTips(page: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            showProcessingLoader()
            repository.getTipsVideos(page, {
                hideProcessingLoader()
                if (it != null)
                    tips.postValue(it)
            }, {
                hideProcessingLoader()
                showToast(it.errorMsg)
            })
        }
    }
    // end region

    // region listeners
    // end region
}