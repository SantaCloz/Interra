package com.example.part2.page


import android.content.Intent
import android.os.Bundle
import android.text.TextUtils.replace
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.fragment.app.Fragment
import com.example.part2.MainActivity
import com.example.part2.R
import com.example.part2.activities.RegisterActivity
import com.example.part2.ui.ChangeDataFragment
import com.example.part2.utilits.AUTH
import com.example.part2.utilits.replaceActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.fragment_settings.*


@Suppress("DEPRECATION")
class Settings : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ChangeExit.setOnClickListener {
            AUTH.signOut()
            val intent = Intent(context, RegisterActivity::class.java)
            startActivity(intent)
        }
        ChangeData.setOnClickListener {
            var fr = fragmentManager?.beginTransaction()
            fr?.replace(R.id.setFragment, ChangeDataFragment())
            fr?.addToBackStack("ChangeDataFragment")
            fr?.commit()

            tabLayout?.visibility = View.INVISIBLE
            ChangeData?.visibility = View.INVISIBLE
        }

    }
}




