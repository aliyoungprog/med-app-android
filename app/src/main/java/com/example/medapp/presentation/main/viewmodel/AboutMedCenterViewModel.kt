package com.example.medapp.presentation.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.medapp.domain.entity.MedCenter
import com.example.medapp.domain.entity.NetworkResult
import com.example.medapp.domain.use_case.GetAllMedServicesUseCase
import kotlinx.coroutines.launch

class AboutMedCenterViewModel(private val getAllMedServicesUseCase: GetAllMedServicesUseCase) :
    ViewModel() {

    private val _medCenters = MutableLiveData<NetworkResult<List<MedCenter>>>()
    val medCenters get() = _medCenters

    fun getAllMedCenters() = viewModelScope.launch {
        val response = getAllMedServicesUseCase.invoke()
        _medCenters.value = response
    }
}
