package com.example.ecommerceappmvvm.di

import com.example.ecommerceappmvvm.data.repository.AuthRemoteDataSourceImpl
import com.example.ecommerceappmvvm.data.repository.dataSource.AuthRemoteDataSource
import com.example.ecommerceappmvvm.data.service.AuthService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataModule {

    @Provides
    @Singleton
    fun provideAuthRemoteDataSource(authService: AuthService): AuthRemoteDataSource =
        AuthRemoteDataSourceImpl(authService)
}