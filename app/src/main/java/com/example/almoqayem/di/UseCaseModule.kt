package com.example.almoqayem.di

import com.example.domain.repo.AlmoqayemRepo
import com.example.domain.usecase.GetAlmoqayemUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideAlmoqayemUseCase(almoqayemRepo: AlmoqayemRepo): GetAlmoqayemUseCase{
        return GetAlmoqayemUseCase(almoqayemRepo)
    }

}