package com.example.medapp.data.datasource

import com.example.medapp.domain.repository.MedServiceApi
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val medServiceApi: MedServiceApi
) {
    suspend fun getAllUsers() = medServiceApi.getAllUsers()
}
