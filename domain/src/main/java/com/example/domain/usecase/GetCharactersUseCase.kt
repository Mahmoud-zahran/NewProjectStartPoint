package com.example.domain.usecase

import com.example.domain.repo.AppRepo

class GetCharactersUseCase(private val appRepo: AppRepo) {
suspend operator fun invoke() = appRepo.getCharactersFromRemote()
}