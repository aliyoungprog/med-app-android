package com.example.medapp.data.repositoryimpl

import com.example.medapp.data.datasource.RemoteDataSource
import com.example.medapp.domain.entity.User
import com.example.medapp.domain.repository.MedServiceRepository
import dagger.Provides
import retrofit2.Response
import javax.inject.Inject

class DefaultMedServiceRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource
): MedServiceRepository {

    override suspend fun getAllUsers(): Response<List<User>> {
        return remoteDataSource.getAllUsers()
    }

}
