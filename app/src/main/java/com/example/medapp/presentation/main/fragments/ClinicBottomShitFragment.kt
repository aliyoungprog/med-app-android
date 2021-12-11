package com.example.medapp.presentation.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.medapp.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ClinicBottomShitFragment : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_clinic_bottom_shit, container, false)
    }

    companion object {
        fun getInstance() = ClinicBottomShitFragment()
    }
}
