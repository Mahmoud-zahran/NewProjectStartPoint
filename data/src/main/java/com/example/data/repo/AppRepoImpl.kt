package com.example.data.repo

import com.example.data.remote.ApiService
import com.example.domain.model.BaseResponse
import com.example.domain.repo.AppRepo
import com.example.domain.model.Result

class AppRepoImpl(private val apiService: ApiService):AppRepo {
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