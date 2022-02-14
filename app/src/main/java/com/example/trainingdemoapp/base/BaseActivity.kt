package com.example.trainingdemoapp.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.example.trainingdemoapp.extensions.showToast
import com.example.trainingdemoapp.models.LoaderModel
import com.example.trainingdemoapp.sharedPreference.SharedPreference
import com.example.trainingdemoapp.helpers.ProgressLoader.dismiss
import com.example.trainingdemoapp.helpers.ProgressLoader.show
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
            vmLoadingObserver.observe(this@BaseActivity, baseLoadingObserver)
            vmMessageObserver.observe(this@BaseActivity, baseToastMessageObserver)
        }
    }
    // end region

    //region Public Methods
    fun showLoading(
        title: String? = null,
        isCancellable: Boolean = false,
        timeOut: Long? = null
    ) {
        if (isFinishing) return
        show(this, title, isCancellable = isCancellable, timeOut = timeOut)
    }

    fun dismissLoading() {
        dismiss()
    }

    fun showToastMessage(message: Any?) {
        showToast(message)
    }
    //endregion

    //region CallBack
    val baseLoadingObserver = Observer<LoaderModel?> { loading ->
        if (loading?.status == true) showLoading(loading.message)
        else dismissLoading()
    }

    val baseToastMessageObserver = Observer<Any?> {
        showToast(it)
    }
    //endregion
}