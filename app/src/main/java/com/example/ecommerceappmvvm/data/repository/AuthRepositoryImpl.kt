package com.example.ecommerceappmvvm.data.repository

import com.example.ecommerceappmvvm.data.repository.dataSource.AuthRemoteDataSource
import com.example.ecommerceappmvvm.domain.model.User
import com.example.ecommerceappmvvm.domain.model.repository.AuthRepository
import com.example.ecommerceappmvvm.domain.model.repository.Response
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(private val authRemoteDataSource: AuthRemoteDataSource) : AuthRepository {
    override suspend fun login(email: String, password: String): Response<User> {
        return try {
            val result = authRemoteDataSource.login(email, password)
            Response.Success(result.body()!!)
        } catch (e: Exception) {
            e.printStackTrace()
            Response.Failure(e)
        }
    }
}