package com.example.part2.ui

import android.os.Bundle
import android.view.*
import android.view.View.VISIBLE
import androidx.fragment.app.Fragment
import com.example.part2.MainActivity
import com.example.part2.R
import com.example.part2.utilits.*
import com.example.part2.utilits.REF_DATABASE_ROOT
import kotlinx.android.synthetic.main.fragment_change_data.*
import kotlinx.android.synthetic.main.fragment_settings.*


@Suppress("DEPRECATION")
class ChangeDataFragment : Fragment(R.layout.fragment_change_data) {
    override fun onResume() {
        super.onResume()
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        (activity as MainActivity).menuInflater.inflate(R.menu.settings_menu_confirm, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.settings_confirm_change ->changeName()
        }
        return true
    }

    private fun changeName() {
        val name = settings_input.text.toString()
        val surname = settings_input_surname.text.toString()
        if (name.isEmpty()) {
            showToast("Имя не может быть пустым")
        } else {
            if (surname.isEmpty()) {
                showToast("Фамилия не может быть пустой")
            } else {
                val fullname = "$name $surname"
                REF_DATABASE_ROOT.child(NODE_USERS).child(UID).child(CHILD_FULLNAME)
                    .setValue(fullname)
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            showToast("Данные обновлены")
                            USER.fullname = fullname
                            fragmentManager?.popBackStack()
                            ChangeData?.visibility = VISIBLE
                        }
                    }
            }
        }
    }
}

