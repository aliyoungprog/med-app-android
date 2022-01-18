package com.example.medapp.presentation.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.medapp.R
import com.example.medapp.presentation.main.viewmodel.SymptomsViewModel
import com.example.medapp.utils.setSafeClickListener
import kotlinx.android.synthetic.main.custom_tab_layout.*

class SymptomsFragment : Fragment() {

    private val backBtn get() = tab_back_btn
    private val nameTxt get() = tab_name_txt

    private lateinit var viewModel: SymptomsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.symptoms_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()
    }

    private fun initView() {
        backBtn.setSafeClickListener { findNavController().popBackStack() }
        nameTxt.text = "Симптомы"
    }
}
