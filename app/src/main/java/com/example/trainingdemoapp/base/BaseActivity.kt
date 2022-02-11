package com.example.trainingdemoapp.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.databinding.ViewDataBinding
import com.example.trainingdemoapp.sharedPreference.SharedPreference
import javax.inject.Inject

abstract class BaseActivity<VM : ViewModel, VB : ViewDataBinding> : AppCompatActivity() {

    // region properties
    @Inject
    lateinit var sharedPreference: SharedPreference
    // end region

    // region protected properties
    protected abstract val mViewModel: VM
    protected lateinit var mViewBinding: VB
    // endregion

    // region lifecycle methods
    abstract fun customOnCreate(savedInstanceState: Bundle?)

    abstract fun getViewBinding(): VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewBinding = getViewBinding()
        setContentView(mViewBinding.root)
        mViewBinding.lifecycleOwner = this
        setObservers()
        customOnCreate(savedInstanceState)
    }
    // end region

    // region private funtions
    private fun setObservers() {
        (mViewModel as? BaseViewModel)?.apply {

        }
    }
    // end region
}