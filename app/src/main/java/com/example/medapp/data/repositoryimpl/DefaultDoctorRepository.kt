package com.example.medapp.data.repositoryimpl

import com.example.medapp.data.datasource.RetrofitBuilder
import com.example.medapp.domain.entity.MedDoctor
import com.example.medapp.domain.repository.DoctorRepository
import retrofit2.Response

class DefaultDoctorRepository(private val retrofitBuilder: RetrofitBuilder) : DoctorRepository {
    override suspend fun getAllDoctors(): Response<List<MedDoctor>> {
        return retrofitBuilder.create().getAllDoctors()
    }

    override suspend fun getDoctorById(doctor_id: Int): Response<MedDoctor> {
        return retrofitBuilder.create().getDoctorById(doctor_id)
    }
}
