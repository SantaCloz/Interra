package com.example.part2.utilits

import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.part2.R
import com.example.part2.activities.RegisterActivity

fun Fragment.showToast(message: String){
    Toast.makeText(this.context,message,Toast.LENGTH_SHORT).show()
}


fun AppCompatActivity.replaceActivity(activity: AppCompatActivity){
    val intent = Intent(this, activity::class.java)
    startActivity(intent)
    this.finish()
}



