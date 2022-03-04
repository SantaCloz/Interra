package com.example.part2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.part2.databinding.ActivityMainBinding
import com.example.part2.utilits.AUTH
import com.example.part2.utilits.initFirebase
import com.example.part2.utilits.replaceActivity
import com.google.android.material.tabs.TabLayout
import com.example.part2.activities.RegisterActivity as RegisterActivity


class MainActivity : AppCompatActivity() {



    private lateinit var mBinding: ActivityMainBinding
    private lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

    }

    override fun onStart() {
        super.onStart()
        initFields()
        initFunc()

    }

    private fun initFunc() {
        if (AUTH.currentUser != null) {
            createTab()

        } else {
            replaceActivity(RegisterActivity())
        }
    }

    private fun initFields() {
        tabLayout = mBinding.tabLayout
        viewPager = mBinding.viewPager
        initFirebase()
            }

    private fun createTab() {
        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewPager)
        tabLayout.addTab(tabLayout.newTab().setText("Главная").setIcon(R.drawable.ic_home))
        tabLayout.addTab(tabLayout.newTab().setText("Врачи").setIcon(R.drawable.ic_doctors))
        tabLayout.addTab(tabLayout.newTab().setText("Расписание").setIcon(R.drawable.ic_rasp))
        tabLayout.addTab(tabLayout.newTab().setText("Контакты").setIcon(R.drawable.ic_contact))
        tabLayout.addTab(tabLayout.newTab().setText("О клинике").setIcon(R.drawable.ic_about))
        tabLayout.addTab(tabLayout.newTab().setText("Настройки").setIcon(R.drawable.ic_settings))
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL
        val adapter = MyAdapter(
            this, supportFragmentManager,
            tabLayout.tabCount
        )
        viewPager.adapter = adapter
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }





}










