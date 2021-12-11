package com.example.medapp.presentation.registration.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.medapp.R
import com.example.medapp.utils.setSafeClickListener
import kotlinx.android.synthetic.main.fragment_main_registration.*

class RegistrationMainFragment : Fragment() {

    private val exit_btn get() = registry_hide_img

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main_registration, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        exit_btn.setSafeClickListener {
            requireActivity().finish()
        }
    }
}
