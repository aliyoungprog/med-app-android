package com.example.medapp.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.medapp.domain.entity.NetworkResult
import com.example.medapp.domain.entity.User
import com.example.medapp.domain.repository.MedServiceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainFragmentViewModel @Inject constructor(
    private val repository: MedServiceRepository
): ViewModel() {

    val userResponse = MutableLiveData<NetworkResult<List<User>>>()

    private fun checkConnection() : Boolean{
        return false
    }

    fun getAllUsers() = viewModelScope.launch {
        val response = repository.getAllUsers()
        userResponse.value = NetworkResult.Success(response.body()!!)
    }
}
