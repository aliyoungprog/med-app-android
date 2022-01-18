package com.example.medapp.presentation.main.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.medapp.R
import kotlinx.android.synthetic.main.fragment_my_health.*


class MyHealthFragment : Fragment() {

    private val healthTab get() = health_tab
    private val shouldRegisterImg get() = health_not_registered_img
    private val shouldRegisterTxt get() = health_not_registered_txt

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_my_health, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        val pref = context?.getSharedPreferences("user_data", Context.MODE_PRIVATE)
        val phoneNumber = pref?.getString("user_phoneNumber", "")
        if (!phoneNumber.isNullOrBlank()) {
            healthTab.visibility = View.VISIBLE
            shouldRegisterImg.visibility = View.GONE
            shouldRegisterTxt.visibility = View.GONE
        } else {
            healthTab.visibility = View.GONE
            shouldRegisterImg.visibility = View.VISIBLE
            shouldRegisterTxt.visibility = View.VISIBLE
        }
    }
}
