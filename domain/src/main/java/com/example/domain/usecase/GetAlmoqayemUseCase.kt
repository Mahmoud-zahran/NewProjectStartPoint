package com.example.domain.usecase

import com.example.domain.repo.AlmoqayemRepo

class GetAlmoqayemUseCase(private val almoqayemRepo: AlmoqayemRepo) {
suspend operator fun invoke() = almoqayemRepo.getCharactersFromRemote()
}