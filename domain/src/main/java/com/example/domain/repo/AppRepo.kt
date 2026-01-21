package com.example.domain.repo
import com.example.domain.model.Result

import com.example.domain.model.BaseResponse

interface AppRepo {
   suspend fun getCharactersFromRemote():Result<BaseResponse<Int>>

}