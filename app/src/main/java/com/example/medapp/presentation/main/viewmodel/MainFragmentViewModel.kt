package com.example.medapp.presentation.main.viewmodel

import androidx.lifecycle.*
import com.example.medapp.domain.entity.MedCenter
import com.example.medapp.domain.entity.NetworkResult
import com.example.medapp.domain.entity.News
import com.example.medapp.domain.use_case.GetAllNewsUseCase
import com.example.medapp.domain.use_case.GetBestMedCenters
import com.example.medapp.utils.Event
import kotlinx.coroutines.launch

class MainFragmentViewModel(
    private val getBestMedCenters: GetBestMedCenters,
    private val getAllNewsUseCase: GetAllNewsUseCase
) : ViewModel() {

    private val _medCenter = MutableLiveData<MedCenter>()
    val medCenter: LiveData<Event<MedCenter>> = _medCenter.map { Event(it) }

    private val _bestMedCenters = MutableLiveData<NetworkResult<List<MedCenter>>>()
    val bestMedCenters = _bestMedCenters

    private val _news = MutableLiveData<NetworkResult<List<News>>>()
    val news = _news


    fun selectMedCenterFromAdapter(medCenter: MedCenter) = viewModelScope.launch {
        _medCenter.value = medCenter
    }

    fun getBestMedCenters() = viewModelScope.launch {
        _bestMedCenters.value = getBestMedCenters.invoke()
    }

    fun getAllNews() = viewModelScope.launch {
        _news.value = getAllNewsUseCase.invoke()
    }
}
