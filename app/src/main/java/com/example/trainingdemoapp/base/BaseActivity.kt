package com.example.trainingdemoapp.base

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
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

    fun onBackClick(view: View) {
        onBackPressed()
    }

    fun showToastMessage(message: Any?) {
        showToast(message)
    }

    fun statusBarColor(id: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window: Window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = ContextCompat.getColor(this, id)
        }
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