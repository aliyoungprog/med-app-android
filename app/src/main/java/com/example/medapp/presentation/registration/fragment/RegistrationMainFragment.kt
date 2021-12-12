package com.example.medapp.presentation.registration.fragment


import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.medapp.R
import com.example.medapp.domain.entity.NetworkResult
import com.example.medapp.domain.entity.User
import com.example.medapp.presentation.registration.viewmodel.RegistrationViewModel
import com.example.medapp.utils.SharedPrefInstance
import com.example.medapp.utils.observeEvent
import com.example.medapp.utils.setSafeClickListener
import kotlinx.android.synthetic.main.fragment_main_registration.*
import org.koin.android.viewmodel.ext.android.viewModel

class RegistrationMainFragment : Fragment() {

    private val exit_btn get() = registry_hide_img
    private val fnameInput get() = user_fname_input
    private val lnameInput get() = user_lname_input
    private val phoneNumberInput get() = user_cellphone_input
    private val submitBtn get() = btn_submit
    private val authBtn get() = authorization_btn

    private val registrationViewModel: RegistrationViewModel by viewModel()

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
        initObservables()
    }

    private fun initView() {
        exit_btn.setSafeClickListener {
            requireActivity().finish()
        }

        submitBtn.setSafeClickListener {
            addUser()
        }

        authBtn.setSafeClickListener {
            findNavController().navigate(
                RegistrationMainFragmentDirections.actionRegistrationMainFragmentToRegistrationAuthFragment()
            )
        }
    }

    private fun addUser() {
        if (!fnameInput.text.isNullOrBlank() && !lnameInput.text.isNullOrBlank() && !phoneNumberInput.text.isNullOrBlank()) {
            registrationViewModel.createUser(
                User(
                    fname = fnameInput.text.toString(),
                    lname = lnameInput.text.toString(),
                    phone_number = phoneNumberInput.text.toString()
                )
            )
        } else {
            showMessage("Пожалуйста, заполните все поля!")
        }
    }

    private fun initObservables() {
        registrationViewModel.user.observeEvent(viewLifecycleOwner, {
            when (it) {
                is NetworkResult.Success -> saveUser(it.data!!)
                is NetworkResult.Error -> showMessage(it.message!!)
                is NetworkResult.Loading -> {
                }
            }
        })
    }

    private fun saveUser(user: User) {
        SharedPrefInstance.save(user, context, "Регистрация прошла успешно!")
        activity?.finish()
    }

    private fun showMessage(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}
