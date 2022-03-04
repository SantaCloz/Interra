package com.example.part2.ui

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import com.example.part2.MainActivity
import com.example.part2.R
import com.example.part2.activities.RegisterActivity
import com.example.part2.utilits.*
import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.android.synthetic.main.fragment_change_data.*
import kotlinx.android.synthetic.main.fragment_change_data.settings_input
import kotlinx.android.synthetic.main.fragment_enter_code.*
import kotlinx.android.synthetic.main.fragment_register_data.*
import kotlinx.android.synthetic.main.fragment_settings.*

class RegisterDataFragment( val PhoneNumber: String, val id: String) :
    Fragment(R.layout.fragment_register_data){
    override fun onResume() {
        super.onResume()
        setHasOptionsMenu(true)
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        (activity as RegisterActivity).menuInflater.inflate(R.menu.settings_menu_confirm, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.settings_confirm_change ->registerData()
        }
        return true
    }
        private fun registerData() {
            val uid = AUTH.currentUser?.uid.toString()
            val name = input_name.text.toString()
            val surname = settings_input_surname?.text.toString()
            if (name.isEmpty()) {
                showToast("Имя не может быть пустым")
            } else {
                if (surname.isEmpty()) {
                    showToast("Фамилия не может быть пустой")
                } else {
                    val fullname = "$name $surname"
                    val dateMap = mutableMapOf<String, Any>()
                    dateMap[CHILD_ID] = uid
                    dateMap[CHILD_PHONE] = PhoneNumber
                    dateMap[CHILD_USERNAME] = uid
                    dateMap[CHILD_FULLNAME] = fullname
                    dateMap[CHILD_CLASS_ANIMAL] = input_class_animal?.text.toString()
                    dateMap[CHILD_NAME_ANIMAL] = input_name_animal?.text.toString()
                    dateMap[CHILD_AGE_ANIMAL] = input_age_animal?.text.toString()
                    REF_DATABASE_ROOT.child(NODE_USERS).child(uid).updateChildren(dateMap)
                        .addOnCompleteListener { task2 ->
                            if (task2.isSuccessful) {
                                showToast("Добро пожаловать")
                                (activity as RegisterActivity).replaceActivity(MainActivity())
                            } else showToast(task2.exception?.message.toString())
                        }
                }
            }
        }
}
