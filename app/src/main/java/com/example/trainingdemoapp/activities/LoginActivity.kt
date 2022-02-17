package com.example.trainingdemoapp.activities

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.example.trainingdemoapp.R
import com.example.trainingdemoapp.base.BaseActivity
import com.example.trainingdemoapp.databinding.ActivityLoginBinding
import com.example.trainingdemoapp.extensions.enablePasswordVisibility
import com.example.trainingdemoapp.extensions.loadImage
import com.example.trainingdemoapp.extensions.startExtActivity
import com.example.trainingdemoapp.viewModels.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : BaseActivity<LoginViewModel, ActivityLoginBinding>() {

    // region private properties
    private var isVisiblePwd = false
    // end region

    // region lifeCycle methods
    override val mViewModel: LoginViewModel by viewModels()

    override fun getViewBinding() = ActivityLoginBinding.inflate(layoutInflater)

    override fun customOnCreate(savedInstanceState: Bundle?) {
        mViewBinding.viewModel = mViewModel
        setLoginObservers()
    }
    // end region

    // region private functions
    private fun setLoginObservers() {
        mViewModel.logInObserver.observe(this, {
            if (it)
                startExtActivity(MainActivity::class.java, isFinish = true)
        })
    }
    // end region

    // region public functions
    fun hideAndShowPassword(v: View) {
        mViewBinding.apply {
            imgHideshowpwd.loadImage(if (isVisiblePwd) R.drawable.ic_eye else R.drawable.ic_closed_eye)
            edtPassword.enablePasswordVisibility(!isVisiblePwd)
        }
        isVisiblePwd = !isVisiblePwd
    }
    // end region

}