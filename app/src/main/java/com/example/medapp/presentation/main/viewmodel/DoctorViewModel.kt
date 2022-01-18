package com.example.medapp.presentation.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.medapp.domain.entity.MedDoctor
import com.example.medapp.domain.entity.NetworkResult
import com.example.medapp.domain.use_case.GetAllDoctorsUseCase
import com.example.medapp.domain.use_case.GetDoctorByIdUseCase
import kotlinx.coroutines.launch

class DoctorViewModel(
    private val getAllDoctorsUseCase: GetAllDoctorsUseCase,
    private val getDoctorByIdUseCase: GetDoctorByIdUseCase
) : ViewModel() {

    private val _medDoctors = MutableLiveData<NetworkResult<List<MedDoctor>>>()
    val medDoctors = _medDoctors


    private val _medDoctor = MutableLiveData<NetworkResult<MedDoctor>>()
    val medDoctor = _medDoctor

    fun getAllDoctors() = viewModelScope.launch {
        _medDoctors.value = getAllDoctorsUseCase.invoke()
    }

    fun getDoctorById(doctor_id: Int) = viewModelScope.launch {
        _medDoctor.value = getDoctorByIdUseCase.invoke(doctor_id)
    }


}
