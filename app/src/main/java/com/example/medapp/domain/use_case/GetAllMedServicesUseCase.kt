package com.example.medapp.domain.use_case

import com.example.medapp.domain.entity.MedCenter
import com.example.medapp.domain.entity.NetworkResult
import com.example.medapp.domain.repository.MedCenterRepository

class GetAllMedServicesUseCase(private val medCentersRepository: MedCenterRepository) {
    suspend operator fun invoke(): NetworkResult<List<MedCenter>> {
        val response = medCentersRepository.getAllMedCenters()
        return if (response.isSuccessful) {
            NetworkResult.Success(response.body()!!)
        } else {
            NetworkResult.Error(message = response.message())
        }
    }
}
