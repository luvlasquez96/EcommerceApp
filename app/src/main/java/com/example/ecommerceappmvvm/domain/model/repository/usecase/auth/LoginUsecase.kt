package com.example.ecommerceappmvvm.domain.model.repository.usecase.auth

import com.example.ecommerceappmvvm.domain.model.repository.AuthRepository

class LoginUsecase(private val authRepository: AuthRepository) {
    suspend operator fun invoke(email: String, password: String) =
        authRepository.login(email, password)
}