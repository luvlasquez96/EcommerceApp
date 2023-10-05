package com.example.ecommerceappmvvm.di

import com.example.ecommerceappmvvm.data.repository.AuthRemoteDataSourceImpl
import com.example.ecommerceappmvvm.data.repository.dataSource.AuthRemoteDataSource
import com.example.ecommerceappmvvm.data.service.AuthService
import com.example.ecommerceappmvvm.domain.model.repository.AuthRepository
import com.example.ecommerceappmvvm.domain.model.repository.usecase.auth.AuthUsecase
import com.example.ecommerceappmvvm.domain.model.repository.usecase.auth.LoginUsecase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UsecaseModule {

        @Provides
        @Singleton
        fun provideAuthUsecase(authRepository: AuthRepository)= AuthUsecase(
            login = LoginUsecase(authRepository)
        )
}