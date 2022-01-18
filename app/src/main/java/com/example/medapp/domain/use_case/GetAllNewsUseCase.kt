package com.example.medapp.domain.use_case

import com.example.medapp.domain.entity.NetworkResult
import com.example.medapp.domain.entity.News
import com.example.medapp.domain.repository.MedCenterRepository

class GetAllNewsUseCase(
    private val medCentersRepository: MedCenterRepository
) {

    suspend operator fun invoke(): NetworkResult<List<News>> {
        val response = medCentersRepository.getAllNews()
        return if (response.isSuccessful) {
            NetworkResult.Success(response.body()!!)
        } else {
            NetworkResult.Error(message = response.message())
        }
    }
}
