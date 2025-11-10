package com.example.almoqayem.di

import com.example.data.remote.ApiService
import com.example.data.repo.AlmoqayemRepoImpl
import com.example.domain.repo.AlmoqayemRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    fun provideRepo(apiService: ApiService): AlmoqayemRepo{
        return AlmoqayemRepoImpl(apiService)
    }
}