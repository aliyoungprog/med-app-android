package com.example.medapp.domain.use_case

import com.example.medapp.domain.entity.NetworkResult
import com.example.medapp.domain.entity.User
import com.example.medapp.domain.repository.UserRepository

class AuthorizationUseCase(private val userRepository: UserRepository) {
    suspend operator fun invoke(phoneNumber: String): NetworkResult<User> {
        val user = userRepository.authByPhoneNumber(phoneNumber)
        return if (user != null) {
            NetworkResult.Success(user.body()!!)
        } else {
            NetworkResult.Error()
        }
    }
}
