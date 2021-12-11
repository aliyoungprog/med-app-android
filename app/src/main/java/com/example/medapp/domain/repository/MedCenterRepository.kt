package com.example.medapp.domain.repository

import com.example.medapp.domain.entity.MedCenter
import com.example.medapp.domain.entity.User
import retrofit2.Response

interface MedCenterRepository {
    suspend fun getAllUsers(): Response<List<User>>
    suspend fun getAllMedCenters(): Response<List<MedCenter>>
    suspend fun getBestMedCenters(): Response<List<MedCenter>>
}
