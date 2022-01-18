package com.example.medapp.presentation.registration.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.medapp.R
import com.example.medapp.domain.entity.NetworkResult
import com.example.medapp.domain.entity.User
import com.example.medapp.presentation.registration.viewmodel.AuthViewModel
import com.example.medapp.utils.SharedPrefInstance
import com.example.medapp.utils.observeEvent
import com.example.medapp.utils.setSafeClickListener
import kotlinx.android.synthetic.main.fragment_authorization.*
import org.koin.android.viewmodel.ext.android.viewModel

class RegistrationAuthFragment : Fragment() {

    private val phoneNumber get() = user_phone_txt
    private val submitBtn get() = auth_btn_submit
    private val hideBtn get() = auth_hide_img

    private val cellNumber get() = user_phone_input
    private val uinNumber get() = user_uin_input

    private val cellTxt get() = user_phone_txt
    private val uinTxt get() = user_uin_txt
    private val checkBox get() = authorization_check_box

    private val authViewModel: AuthViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_authorization, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
        initViewModel()
    }

    private fun setListeners() {
        submitBtn.setSafeClickListener {
            if (!phoneNumber.text.isNullOrBlank()) {
                authViewModel.authUserByPhoneNumber(phoneNumber.text.toString())
            }
        }
    }

    private fun initViewModel() {
        authViewModel.user.observeEvent(viewLifecycleOwner, {
            when (it) {
                is NetworkResult.Success -> saveUser(it.data!!)
                is NetworkResult.Error -> {
                }
                is NetworkResult.Loading -> {
                }
            }

        })
        checkBox.setSafeClickListener {
            if (checkBox.isChecked) {
                cellNumber.visibility = View.VISIBLE
                uinNumber.visibility = View.GONE


            } else {
                cellNumber.visibility = View.GONE
                uinNumber.visibility = View.VISIBLE
            }
        }
    }

    private fun saveUser(user: User) {
        SharedPrefInstance.save(user, context, "С возвращением!")
        activity?.finish()
    }
}
