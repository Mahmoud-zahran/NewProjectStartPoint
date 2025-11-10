package com.example.data.repo

import com.example.data.remote.ApiService
import com.example.domain.model.BaseResponse
import com.example.domain.repo.AlmoqayemRepo
import com.example.domain.model.Result

class AlmoqayemRepoImpl(private val apiService: ApiService):AlmoqayemRepo {
    override suspend fun getCharactersFromRemote():Result<BaseResponse<Int>> {
        return try {
            val response = apiService.getCharacters()
            if (response.isSuccessful) {
                Result.Success(response.body()!!)
            } else {
                Result.Error("Error: ${response.code()}")
            }
        } catch (e: Exception) {
            Result.Error("Exception: ${e.localizedMessage}", e)
        }
    }

}