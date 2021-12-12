package com.example.medapp.presentation.main.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.medapp.R
import com.example.medapp.utils.setSafeClickListener
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.profile_fragment_header_component.*


class ProfileFragment : Fragment() {

    private val linearLayout get() = pf_body_linear_layout
    private val headerComponent get() = pf_header_component
    private val notRegistredImage get() = pf_image_view_not_registred
    private val notRegistredText get() = pf_text_view_not_registred_txt
    private val logoutBtn get() = pf_header_logout
    private val pref get()= context?.getSharedPreferences("user_data", Context.MODE_PRIVATE)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        setListeners()
    }

    private fun initView() {
        val phoneNumber = pref?.getString("user_phoneNumber", "")
        if (!phoneNumber.isNullOrBlank()) {
            linearLayout.visibility = View.VISIBLE
            headerComponent.visibility = View.VISIBLE
            notRegistredImage.visibility = View.GONE
            notRegistredText.visibility = View.GONE
        } else {
            linearLayout.visibility = View.GONE
            headerComponent.visibility = View.GONE
            notRegistredImage.visibility = View.VISIBLE
            notRegistredText.visibility = View.VISIBLE
        }
    }

    private fun setListeners() {
        logoutBtn.setSafeClickListener {
            pref?.edit()?.clear()?.apply()
            initView()
        }
    }
}
