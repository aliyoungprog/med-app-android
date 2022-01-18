package com.example.medapp.presentation.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.medapp.R
import com.example.medapp.domain.entity.MedService
import com.example.medapp.presentation.main.adapters.ServiceItemAdapter
import com.example.medapp.presentation.main.viewmodel.ServicesViewModel
import com.example.medapp.utils.setSafeClickListener
import kotlinx.android.synthetic.main.custom_tab_layout.*
import kotlinx.android.synthetic.main.services_fragment.*

class ServicesFragment : Fragment() {

    private val backBtn get() = tab_back_btn
    private val nameTxt get() = tab_name_txt
    private val recycler get() = service_item_recycler
    private lateinit var viewModel: ServicesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.services_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()
    }

    private fun initView() {
        backBtn.setSafeClickListener { findNavController().popBackStack() }
        nameTxt.text = "Услуги"

        service_item_recycler.adapter = ServiceItemAdapter(
            listOf(
                MedService(serviceName = "Массаж"),
                MedService(serviceName = "Терапевт"),
                MedService(serviceName = "Стамотолог"),
                MedService(serviceName = "Психолог")
            )
        )
    }
}
