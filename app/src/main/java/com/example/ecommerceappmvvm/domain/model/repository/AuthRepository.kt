package com.example.ecommerceappmvvm.domain.model.repository

import com.example.ecommerceappmvvm.domain.model.User

interface AuthRepository {

    suspend fun login(email: String, password: String): Response<User>
}