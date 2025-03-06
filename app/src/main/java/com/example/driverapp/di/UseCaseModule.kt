package com.example.driverapp.di

import com.example.domain.repo.DriverRepo
import com.example.domain.usecase.GetDriverUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideDriverUseCase(driverRepo: DriverRepo): GetDriverUseCase{
        return GetDriverUseCase(driverRepo)
    }

}