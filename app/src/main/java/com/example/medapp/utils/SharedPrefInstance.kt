package com.example.medapp.utils

import android.content.Context
import android.widget.Toast
import com.example.medapp.domain.entity.User

object SharedPrefInstance {
    fun save(user: User, ctx: Context?, txt: String) {
        val pref = ctx?.getSharedPreferences("user_data", Context.MODE_PRIVATE)
        val editor = pref?.edit()
        editor?.putString("user_fname", user.fname)
        editor?.putString("user_lname", user.lname)
        editor?.putString("user_phoneNumber", user.phone_number)
        Toast.makeText(ctx, txt, Toast.LENGTH_SHORT).show()
        editor?.apply()
    }
}
