package com.example.medapp.domain.repository

import com.example.medapp.domain.entity.User
import retrofit2.Response

interface UserRepository {
    suspend fun addUser(user: User): Response<User>?
    suspend fun authByPhoneNumber(phoneNumber: String): Response<User>?
}
