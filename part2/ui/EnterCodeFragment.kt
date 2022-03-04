package com.example.part2.ui

import androidx.fragment.app.Fragment
import com.example.part2.MainActivity
import com.example.part2.R
import com.example.part2.activities.RegisterActivity
import com.example.part2.utilits.*
import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.android.synthetic.main.fragment_enter_code.*

@Suppress("DEPRECATION")
class EnterCodeFragment(val PhoneNumber: String, val id: String) :
    Fragment(R.layout.fragment_enter_code) {

        override fun onStart() {
            super.onStart()
            (activity as RegisterActivity).title = PhoneNumber
            register_input_code.addTextChangedListener(AppTextWatcher {
                val string = register_input_code.text.toString()
                if (string.length == 6) {
                    enterCode()
                }
            })
        }

    private fun enterCode() {
        val code = register_input_code.text.toString()
        val credential = PhoneAuthProvider.getCredential(id, code)
        AUTH.signInWithCredential(credential).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                fragmentManager?.beginTransaction()
                    ?.replace(R.id.register_data_container, RegisterDataFragment(PhoneNumber,id))
                    ?.commit()


            } else showToast(task.exception?.message.toString())
        }
    }
}