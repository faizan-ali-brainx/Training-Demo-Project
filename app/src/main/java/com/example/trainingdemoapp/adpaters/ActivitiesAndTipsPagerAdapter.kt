package com.example.trainingdemoapp.adpaters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.trainingdemoapp.R
import com.example.trainingdemoapp.fragments.*

class ActivitiesAndTipsPagerAdapter(fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    val fragmentList: MutableList<Fragment> =
        mutableListOf(TipsFragment(), ActivitiesFragment())
    val fragmentTitles: List<Int> =
        listOf(R.string.tips, R.string.activities)

    override fun getItem(position: Int): Fragment = fragmentList[position]

    override fun getCount(): Int = fragmentList.size

}