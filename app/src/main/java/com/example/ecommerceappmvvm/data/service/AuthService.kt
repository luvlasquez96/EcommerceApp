package com.example.ecommerceappmvvm.data.service

import com.example.ecommerceappmvvm.domain.model.User
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthService {

    @FormUrlEncoded
    @POST("auth/login")
    suspend fun login(@Field("email") email: String, @Field("password") password: String): Response<User>
}