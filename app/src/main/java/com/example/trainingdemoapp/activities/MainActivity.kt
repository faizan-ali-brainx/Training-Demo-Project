package com.example.trainingdemoapp.activities

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.trainingdemoapp.R
import com.example.trainingdemoapp.adpaters.MainMenuPagerAdapter
import com.example.trainingdemoapp.base.BaseActivity
import com.example.trainingdemoapp.databinding.ActivityMainBinding
import com.example.trainingdemoapp.extensions.*
import com.example.trainingdemoapp.utils.Constants.ZERO
import com.example.trainingdemoapp.viewModels.MainViewModel
import com.google.android.material.tabs.TabLayout
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.bottom_nav_layout.*
import kotlinx.android.synthetic.main.bottom_nav_layout.view.*

@AndroidEntryPoint
class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    // region private properties
    private lateinit var mainPagerAdapter: MainMenuPagerAdapter
    // end region

    // region lifeCycle methods
    override fun getViewBinding() = ActivityMainBinding.inflate(layoutInflater)

    override fun customOnCreate(savedInstanceState: Bundle?) {
        mViewBinding.viewModel = mViewModel
        setViewPagerAdapter()
    }

    override val mViewModel: MainViewModel by viewModels()
    // end region

    // region private functions
    private fun setViewPagerAdapter() {
        with(mViewBinding) {
            mainPagerAdapter = MainMenuPagerAdapter(supportFragmentManager)
            mainPagerAdapter.apply {
                with(viewPager) {
                    offscreenPageLimit = fragmentList.size
                    adapter = this@apply
                }
                bottomNavBar.setupWithViewPager(viewPager)
                setTabs()
                selectTab(ZERO)
                bottomNavBar.addOnTabSelectedListener(pagerTabListener)
            }
        }
    }

    private fun setTabs() {
        mViewBinding.bottomNavBar.apply {
            repeat(tabCount) { tabIndex ->
                getTabAt(tabIndex)?.apply {
                    setCustomView(R.layout.bottom_nav_layout)
                    customView?.apply {
                        mainPagerAdapter.apply {
                            item_icon?.loadImage(fragmentIcons[tabIndex])
                            title_tv?.text = resources.getString(fragmentTitles[tabIndex])
                        }
                    }
                }
            }
        }
    }

    private fun selectTab(index: Int) {
        mViewBinding.apply {
            viewPager.currentItem = index
            changeTabIconAndTextColor(bottomNavBar.getTabAt(index)?.customView, true, index)
        }
    }

    private fun changeTabIconAndTextColor(customView: View?, isSelected: Boolean, position: Int) {
        statusBarColor(if (position != ZERO) R.color.white else R.color.bgcolor)
        val textColor = if (isSelected) R.color.headingcolor else R.color.plan_values_color
        val iconColor = if (isSelected) R.color.colorBlueFF else R.color.textcolor
        customView?.apply {
            title_tv?.setTextColor(textColor)
            item_icon?.colorFilter =
                getFilterColor(
                    this@MainActivity,
                    iconColor
                )

        }
    }
    // end region

    // region public functions
    // end region

    // region listeners
    private val pagerTabListener = object : TabLayout.OnTabSelectedListener {
        override fun onTabSelected(tab: TabLayout.Tab) {
            tab.apply {
                changeTabIconAndTextColor(customView, true, position)
            }

        }

        override fun onTabUnselected(tab: TabLayout.Tab) {
            tab.apply {
                changeTabIconAndTextColor(customView, false, position)
            }
        }

        override fun onTabReselected(tab: TabLayout.Tab) = Unit
    }
    // end region
}