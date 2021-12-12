package com.example.medapp.presentation.registration.viewmodel

import androidx.lifecycle.*
import com.example.medapp.domain.entity.NetworkResult
import com.example.medapp.domain.entity.User
import com.example.medapp.domain.use_case.AddUserUseCase
import com.example.medapp.utils.Event
import kotlinx.coroutines.launch

class RegistrationViewModel(private val addUserUseCase: AddUserUseCase) : ViewModel() {

    private val _user = MutableLiveData<NetworkResult<User>>()
    val user: LiveData<Event<NetworkResult<User>>> = _user.map { Event(it) }

    fun createUser(user: User) = viewModelScope.launch {
        _user.value = addUserUseCase.invoke(user)
    }
}
