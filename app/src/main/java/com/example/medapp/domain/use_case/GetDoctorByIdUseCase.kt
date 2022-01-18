package com.example.medapp.domain.use_case

import com.example.medapp.domain.entity.MedDoctor
import com.example.medapp.domain.entity.NetworkResult
import com.example.medapp.domain.repository.DoctorRepository


class GetDoctorByIdUseCase(private val doctorRepository: DoctorRepository) {
    suspend operator fun invoke(doctor_id: Int): NetworkResult<MedDoctor> {
        val response = doctorRepository.getDoctorById(doctor_id)
        return if (response.isSuccessful) {
            NetworkResult.Success(response.body()!!)
        } else {
            NetworkResult.Error(message = response.message())
        }
    }
}
