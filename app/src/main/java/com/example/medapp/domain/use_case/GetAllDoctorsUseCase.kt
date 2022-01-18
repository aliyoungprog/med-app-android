package com.example.medapp.domain.use_case

import com.example.medapp.domain.entity.MedCenter
import com.example.medapp.domain.entity.MedDoctor
import com.example.medapp.domain.entity.NetworkResult
import com.example.medapp.domain.repository.DoctorRepository

class GetAllDoctorsUseCase(private val doctorRepository: DoctorRepository) {
    suspend operator fun invoke(): NetworkResult<List<MedDoctor>> {
        val response = doctorRepository.getAllDoctors()
        return if (response.isSuccessful) {
            NetworkResult.Success(response.body()!!)
        } else {
            NetworkResult.Error(message = response.message())
        }
    }
}
