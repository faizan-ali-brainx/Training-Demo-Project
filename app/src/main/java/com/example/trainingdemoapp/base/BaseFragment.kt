package com.example.trainingdemoapp.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.trainingdemoapp.models.LoaderModel
import com.example.trainingdemoapp.sharedPreference.SharedPreference
import javax.inject.Inject

abstract class BaseFragment<VM : ViewModel, VB : ViewDataBinding> : Fragment() {

    // region lateInit properties
    @Inject
    lateinit var sharedPreference: SharedPreference
    // end region

    // region protected properties
    protected lateinit var mViewBinding: VB
    protected abstract val mViewModel: VM
    // end region

    //region LifeCycle
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        getViewBinding().apply {
            lifecycleOwner = this@BaseFragment
            mViewBinding = this
        }
        customOnViewCreated(savedInstanceState)
        return mViewBinding.root
    }
    // end region

    // region abstract funtions
    abstract fun getViewBinding(): VB

    abstract fun customOnViewCreated(savedInstanceState: Bundle?)
    // end region

    // region public methods
    fun getLoadingObserver(): Observer<LoaderModel?> {
        val requiredActivity = requireActivity() as BaseActivity<VM, VB>
        return requiredActivity.baseLoadingObserver
    }

    fun getErrorObserver(): Observer<Any?> {
        val requiredActivity = requireActivity() as BaseActivity<VM, VB>
        return requiredActivity.baseToastMessageObserver
    }
    // end region
}