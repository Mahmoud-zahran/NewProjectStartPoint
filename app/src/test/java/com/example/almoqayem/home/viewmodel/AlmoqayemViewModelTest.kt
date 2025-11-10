package com.example.almoqayem.home.viewmodel

import com.example.domain.model.BaseResponse
import com.example.domain.model.Data
import com.example.domain.model.Result
import com.example.domain.repo.AlmoqayemRepo
import com.example.domain.usecase.GetAlmoqayemUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi

import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.assertTrue
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class AlmoqayemViewModelTest {

    @Test
    fun `getCharacters final state is Success`() = runTest {
        val testDispatcher = StandardTestDispatcher(testScheduler)
        kotlinx.coroutines.Dispatchers.setMain(testDispatcher)

        val fakeRepo = object : AlmoqayemRepo {
            override suspend fun getCharactersFromRemote(): Result<BaseResponse<Int>> {
                val baseResponse = BaseResponse(
                    attributionHTML = "",
                    attributionText = "",
                    code = 200,
                    copyright = "",
                    data = Data<Int>(count = 1, limit = 0, offset = 0, results = emptyList<Int>(), total = 0),
                    etag = "",
                    status = "ok"
                )
                return Result.Success(baseResponse)
            }
        }

        val useCase = GetAlmoqayemUseCase(fakeRepo)
        val vm = AlmoqayemViewModel(useCase)

        try {
            vm.getCharacters()
            // let ViewModel coroutine run
            testScheduler.advanceUntilIdle()

            val final = vm.characters.value
            assertTrue("Final state should be Success", final is Result.Success)
        } finally {
            kotlinx.coroutines.Dispatchers.resetMain()
        }
    }

    @Test
    fun `getCharacters final state is Error`() = runTest {
        val testDispatcher = StandardTestDispatcher(testScheduler)
        kotlinx.coroutines.Dispatchers.setMain(testDispatcher)

        val fakeRepo = object : AlmoqayemRepo {
            override suspend fun getCharactersFromRemote(): Result<BaseResponse<Int>> {
                return Result.Error("remote failure", Exception("boom"))
            }
        }

        val useCase = GetAlmoqayemUseCase(fakeRepo)
        val vm = AlmoqayemViewModel(useCase)

        try {
            vm.getCharacters()
            testScheduler.advanceUntilIdle()

            val final = vm.characters.value
            assertTrue("Final state should be Error", final is Result.Error)
        } finally {
            kotlinx.coroutines.Dispatchers.resetMain()
        }
    }
}
