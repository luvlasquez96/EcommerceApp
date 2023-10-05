package com.example.ecommerceappmvvm.data.repository

import com.example.ecommerceappmvvm.data.repository.dataSource.AuthRemoteDataSource
import com.example.ecommerceappmvvm.data.service.AuthService
import com.example.ecommerceappmvvm.domain.model.User
import retrofit2.Response

class AuthRemoteDataSourceImpl(val authService: AuthService): AuthRemoteDataSource {
    override suspend fun login(email: String, password: String) = authService.login(email, password)
}