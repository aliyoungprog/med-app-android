package com.example.medapp.domain.repository

import com.example.medapp.domain.entity.MedDoctor
import retrofit2.Response

interface DoctorRepository {
   suspend fun getAllDoctors(): Response<List<MedDoctor>>
   suspend fun getDoctorById(doctor_id: Int): Response<MedDoctor>
}
