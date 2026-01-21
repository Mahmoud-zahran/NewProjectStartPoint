package com.example.projectname.di

import com.example.domain.repo.AppRepo
import com.example.domain.usecase.GetCharactersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideGetCharactersUseCase(appRepo: AppRepo): GetCharactersUseCase{
        return GetCharactersUseCase(appRepo)
    }

}