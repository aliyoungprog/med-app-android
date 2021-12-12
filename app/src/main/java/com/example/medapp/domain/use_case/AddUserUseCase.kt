package com.example.medapp.domain.use_case

import com.example.medapp.domain.entity.NetworkResult
import com.example.medapp.domain.entity.User
import com.example.medapp.domain.repository.UserRepository

class AddUserUseCase(private val userRepository: UserRepository) {
    suspend operator fun invoke(user: User): NetworkResult<User> {
        val createdUser = userRepository.addUser(user)
        return if (createdUser != null) {
            NetworkResult.Success(createdUser.body()!!)
        } else {
            NetworkResult.Error()
        }
    }
}
