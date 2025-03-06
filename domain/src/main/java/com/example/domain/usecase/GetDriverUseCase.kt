package com.example.domain.usecase

import com.example.domain.repo.DriverRepo

class GetDriverUseCase(private val driverRepo: DriverRepo) {
suspend operator fun invoke() = driverRepo.getCharactersFromRemote()
}