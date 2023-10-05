package com.example.ecommerceappmvvm.di

import com.example.ecommerceappmvvm.data.repository.AuthRemoteDataSourceImpl
import com.example.ecommerceappmvvm.data.repository.AuthRepositoryImpl
import com.example.ecommerceappmvvm.data.repository.dataSource.AuthRemoteDataSource
import com.example.ecommerceappmvvm.domain.model.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Provides
    fun provideAuthRepository(authRemoteDataSource: AuthRemoteDataSource): AuthRepository =
        AuthRepositoryImpl(authRemoteDataSource)
}