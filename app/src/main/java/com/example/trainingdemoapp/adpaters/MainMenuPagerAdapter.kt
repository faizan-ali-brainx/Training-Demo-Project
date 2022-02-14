package com.example.trainingdemoapp.adpaters

import android.provider.Contacts
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.trainingdemoapp.R
import com.example.trainingdemoapp.fragments.HomeFragment
import com.example.trainingdemoapp.fragments.NotificationsFragment
import com.example.trainingdemoapp.fragments.SettingsFragment

class MainMenuPagerAdapter(fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    var fragmentList: MutableList<Fragment> =
        mutableListOf(HomeFragment(), NotificationsFragment(), SettingsFragment())
    var fragmentTitles: List<Int> =
        listOf(R.string.home, R.string.notifications, R.string.settings)
    var fragmentIcons: List<Int> =
        listOf(R.drawable.home, R.drawable.notification, R.drawable.settings)

    override fun getItem(position: Int): Fragment = fragmentList[position]

    override fun getCount(): Int = fragmentList.size

}