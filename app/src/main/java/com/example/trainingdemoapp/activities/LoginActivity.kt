package com.example.trainingdemoapp.activities

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.example.trainingdemoapp.base.BaseActivity
import com.example.trainingdemoapp.databinding.ActivityLoginBinding
import com.example.trainingdemoapp.extensions.showToast
import com.example.trainingdemoapp.viewModels.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : BaseActivity<LoginViewModel, ActivityLoginBinding>() {

    // region private properties
    // end region

    // region lifeCycle methods
    override val mViewModel: LoginViewModel by viewModels()

    override fun getViewBinding() = ActivityLoginBinding.inflate(layoutInflater)

    override fun customOnCreate(savedInstanceState: Bundle?) {

    }
    // end region

    // region public funtions
    fun hideAndShowPassword(view: View) {

    }
    // end region

}