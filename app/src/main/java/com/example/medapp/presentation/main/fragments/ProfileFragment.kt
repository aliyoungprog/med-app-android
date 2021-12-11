package com.example.medapp.presentation.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.medapp.R
import kotlinx.android.synthetic.main.fragment_profile.*


class ProfileFragment : Fragment() {

    private val linearLayout get() = pf_body_linear_layout
    private val headerComponent get() = pf_header_component
    private val notRegistredImage get() = pf_image_view_not_registred
    private val notRegistredText get() = pf_text_view_not_registred_txt


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        linearLayout.visibility = View.GONE
        headerComponent.visibility = View.GONE
        notRegistredImage.visibility = View.VISIBLE
        notRegistredText.visibility = View.VISIBLE
    }
}
