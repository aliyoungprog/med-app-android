package com.example.medapp.data.repositoryimpl

import com.example.medapp.data.datasource.RetrofitBuilder
import com.example.medapp.domain.entity.User
import com.example.medapp.domain.repository.UserRepository
import retrofit2.Response

class DefaultUserRepository(private val retrofitBuilder: RetrofitBuilder) : UserRepository {
    override suspend fun addUser(user: User): Response<User> {
        return retrofitBuilder.create().addUser(user)
    }

    override suspend fun authByPhoneNumber(phoneNumber: String): Response<User> {
        return retrofitBuilder.create().getUserByPhoneNumber(phoneNumber)
    }
}
