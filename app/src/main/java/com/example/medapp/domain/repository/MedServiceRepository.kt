package com.example.medapp.domain.repository

import com.example.medapp.domain.entity.User
import dagger.Provides
import dagger.hilt.android.scopes.ActivityRetainedScoped
import retrofit2.Response

interface MedServiceRepository {
    suspend fun getAllUsers(): Response<List<User>>
}
