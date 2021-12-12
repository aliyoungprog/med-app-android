package com.example.medapp.presentation.registration.viewmodel


import androidx.lifecycle.*
import com.example.medapp.domain.entity.NetworkResult
import com.example.medapp.domain.entity.User
import com.example.medapp.domain.use_case.AuthorizationUseCase
import com.example.medapp.utils.Event
import kotlinx.coroutines.launch

class AuthViewModel(private val authorizationUseCase: AuthorizationUseCase) : ViewModel() {

    private val _user = MutableLiveData<NetworkResult<User>>()
    val user: LiveData<Event<NetworkResult<User>>> = _user.map { Event(it) }

    fun authUserByPhoneNumber(phoneNumber: String) = viewModelScope.launch {
        _user.value = authorizationUseCase.invoke(phoneNumber)
    }
}
