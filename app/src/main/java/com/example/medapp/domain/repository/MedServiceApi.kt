package com.example.medapp.domain.repository

import com.example.medapp.domain.entity.User
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MedServiceApi {
    @GET("/users/")
    suspend fun getAllUsers(): Response<List<User>>
}
