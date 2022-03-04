package com.example.part2.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.part2.R
import com.example.part2.databinding.ActivityRegisterBinding


import com.example.part2.ui.EnterPhoneNumberFragment
import com.example.part2.utilits.initFirebase

class RegisterActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding= ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        initFirebase()
    }

    override fun onStart() {
        super.onStart()
        title=getString(R.string.register_tittle_your_phone)
        supportFragmentManager.beginTransaction()
            .add(R.id.register_data_container,EnterPhoneNumberFragment())
            .commit()
    }

    fun onChangeData(view: View) {}
}