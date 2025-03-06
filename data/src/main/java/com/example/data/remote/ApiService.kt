package com.example.data.remote

import com.example.domain.model.BaseResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.Response

interface ApiService {
//    get /v1/public/characters
@GET("characters")
suspend fun getCharacters(): Response<BaseResponse<Int>>

}
