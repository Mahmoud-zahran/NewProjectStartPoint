package com.example.projectname.di

import com.example.data.remote.ApiService
import com.example.data.repo.AppRepoImpl
import com.example.domain.repo.AppRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    fun provideRepo(apiService: ApiService): AppRepo{
        return AppRepoImpl(apiService)
    }
}