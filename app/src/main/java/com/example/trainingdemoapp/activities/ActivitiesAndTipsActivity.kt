package com.example.trainingdemoapp.activities

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.example.trainingdemoapp.R
import com.example.trainingdemoapp.adpaters.ActivitiesAndTipsPagerAdapter
import com.example.trainingdemoapp.adpaters.MainMenuPagerAdapter
import com.example.trainingdemoapp.base.BaseActivity
import com.example.trainingdemoapp.databinding.ActivityActivitiesAndTipsBinding
import com.example.trainingdemoapp.extensions.loadImage
import com.example.trainingdemoapp.extensions.setCustomTextColor
import com.example.trainingdemoapp.utils.Constants
import com.example.trainingdemoapp.viewModels.ActivitiesAndTipsViewModel
import com.google.android.material.tabs.TabLayout
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activities_and_tips_tab_layout.view.*
import kotlinx.android.synthetic.main.bottom_nav_layout.view.*

@AndroidEntryPoint
class ActivitiesAndTipsActivity :
    BaseActivity<ActivitiesAndTipsViewModel, ActivityActivitiesAndTipsBinding>() {

    // region private properties
    private lateinit var activitiesAndTipsPagerAdapter: ActivitiesAndTipsPagerAdapter
    // end region

    // region lifeCycle methods
    override val mViewModel: ActivitiesAndTipsViewModel by viewModels()

    override fun customOnCreate(savedInstanceState: Bundle?) {
        setViewPagerAdapter()
    }

    override fun getViewBinding() = ActivityActivitiesAndTipsBinding.inflate(layoutInflater)
    // end region

    // region private functions
    private fun setViewPagerAdapter() {
        with(mViewBinding) {
            activitiesAndTipsPagerAdapter = ActivitiesAndTipsPagerAdapter(supportFragmentManager)
            activitiesAndTipsPagerAdapter.apply {
                with(viewPager) {
                    offscreenPageLimit = fragmentList.size
                    adapter = this@apply
                }
                tabLayout.apply {
                    setupWithViewPager(viewPager)
                    setTabs()
                    selectTab(Constants.ZERO)
                    addOnTabSelectedListener(pagerTabListener)
                }
            }
        }
    }

    private fun setTabs() {
        mViewBinding.tabLayout.apply {
            repeat(tabCount) { tabIndex ->
                getTabAt(tabIndex)?.apply {
                    setCustomView(R.layout.activities_and_tips_tab_layout)
                    customView?.apply {
                        activitiesAndTipsPagerAdapter.apply {
                            tv_TabTitle?.text = resources.getString(fragmentTitles[tabIndex])
                        }
                    }
                }
            }
        }
    }

    private fun selectTab(index: Int) {
        mViewBinding.apply {
            viewPager.currentItem = index
            changeTabTextColor(tabLayout.getTabAt(index)?.customView, true)
        }
    }

    private fun changeTabTextColor(customView: View?, isSelected: Boolean) {
        customView?.tv_TabTitle?.setCustomTextColor(
            if (isSelected) R.color.headingcolor else R.color.unselectedcolor
        )
    }

    private val pagerTabListener = object : TabLayout.OnTabSelectedListener {
        override fun onTabSelected(tab: TabLayout.Tab) {
            tab.apply {
                changeTabTextColor(customView, true)
            }

        }

        override fun onTabUnselected(tab: TabLayout.Tab) {
            tab.apply {
                changeTabTextColor(customView, false)
            }
        }

        override fun onTabReselected(tab: TabLayout.Tab) = Unit
    }
    // end region

    // region public functions
    // end region

    // region listeners
    // end region

}