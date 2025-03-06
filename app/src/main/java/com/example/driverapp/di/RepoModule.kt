package com.example.driverapp.di

import com.example.data.remote.ApiService
import com.example.data.repo.DriverRepoImpl
import com.example.domain.repo.DriverRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    fun provideRepo(apiService: ApiService): DriverRepo{
        return DriverRepoImpl(apiService)
    }
}