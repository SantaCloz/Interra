@file:Suppress("DEPRECATION")

package com.example.part2

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.part2.page.*

@Suppress("DEPRECATION")
internal class MyAdapter(
    var context: Context,
    fm: FragmentManager,
    var totalTabs: Int
) :
    FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                Home()
            }
            1 -> {
                Doctors()
            }
            2 -> {
                Rasp()
            }
            3 -> {
                Contact()
            }
            4 -> {
                About()
            }
            5 -> {
                Settings()
            }

            else -> getItem(position)
        }
    }
    override fun getCount(): Int {
        return totalTabs
    }
}