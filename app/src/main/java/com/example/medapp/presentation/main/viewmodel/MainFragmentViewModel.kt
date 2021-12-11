package com.example.medapp.presentation.main.viewmodel

import androidx.lifecycle.*
import com.example.medapp.domain.entity.MedCenter
import com.example.medapp.domain.entity.NetworkResult
import com.example.medapp.domain.use_case.GetBesMedCenters
import com.example.medapp.utils.Event
import kotlinx.coroutines.launch

class MainFragmentViewModel(
    private val getBesMedCenters: GetBesMedCenters
) : ViewModel() {

    private val _medCenter = MutableLiveData<MedCenter>()
    val medCenter: LiveData<Event<MedCenter>> = _medCenter.map { Event(it) }

    private val _bestMedCenters = MutableLiveData<NetworkResult<List<MedCenter>>>()
    val bestMedCenters = _bestMedCenters


    fun selectMedCenterFromAdapter(medCenter: MedCenter) = viewModelScope.launch {
        _medCenter.value = medCenter
    }

    fun getBestMedCenters() = viewModelScope.launch {
        _bestMedCenters.value = getBesMedCenters.invoke()
    }
}
