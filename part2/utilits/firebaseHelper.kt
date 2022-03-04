package com.example.part2.utilits

import com.example.part2.models.User
import com.example.part2.ui.EnterCodeFragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase



lateinit var AUTH: FirebaseAuth
internal lateinit var REF_DATABASE_ROOT: DatabaseReference
lateinit var USER: User
lateinit var UID:String

const val NODE_USERS="users"
const val CHILD_ID= "id"
const val CHILD_PHONE= "phone"
const val CHILD_USERNAME= "username"
const val CHILD_FULLNAME="fullname"
const val CHILD_CLASS_ANIMAL="class_animal"
const val CHILD_NAME_ANIMAL="name_animal"
const val CHILD_AGE_ANIMAL="age_animal"
const val CHILD_BIO="bio"



fun initFirebase(){
    AUTH = FirebaseAuth.getInstance()
    REF_DATABASE_ROOT = FirebaseDatabase.getInstance().reference
    USER = User()
    UID= AUTH.currentUser?.uid.toString()
}


