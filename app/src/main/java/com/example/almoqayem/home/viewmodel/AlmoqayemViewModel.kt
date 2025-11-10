package com.example.almoqayem.home.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.BaseResponse
import com.example.domain.usecase.GetAlmoqayemUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.domain.model.Result

const val TAG ="AlmoqayemViewModel"

@HiltViewModel
class AlmoqayemViewModel @Inject constructor(
    private val getAlmoqayemUseCase: GetAlmoqayemUseCase,
): ViewModel() {

    private val _characters: MutableStateFlow<Result<BaseResponse<Int>>?> = MutableStateFlow(null)
    val characters: StateFlow<Result<BaseResponse<Int>>?> = _characters


    fun getCharacters(){
        viewModelScope.launch {
            _characters.value = Result.Loading  // Set loading state
            try {
                val result = getAlmoqayemUseCase()
                _characters.value = result
                Log.d(TAG, "getCharacters: $result")
            } catch (e: Exception) {
                _characters.value = Result.Error("Failed to fetch characters", e)
                Log.e(TAG, "getCharacters Error: ${e.message}")
            }
        }
    }


}