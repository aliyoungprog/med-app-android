package com.example.medapp.data.repositoryimpl

import com.example.medapp.data.datasource.RetrofitBuilder
import com.example.medapp.domain.entity.MedCenter
import com.example.medapp.domain.entity.User
import com.example.medapp.domain.repository.MedCenterRepository
import retrofit2.Response

class DefaultMedCenterRepository(
    private val retrofitBuilder: RetrofitBuilder
) : MedCenterRepository {

    override suspend fun getAllUsers(): Response<List<User>> {
        return retrofitBuilder.create().getAllUsers()
    }

    override suspend fun getAllMedCenters(): Response<List<MedCenter>> {
        return retrofitBuilder.create().getAllMedCenters()
    }

    override suspend fun getBestMedCenters(): Response<List<MedCenter>> {
        return retrofitBuilder.create().getBestMedCenters()
    }
}
