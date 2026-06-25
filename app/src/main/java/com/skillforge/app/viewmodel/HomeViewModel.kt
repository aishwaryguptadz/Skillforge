package com.skillforge.app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.skillforge.app.data.model.ApiResponse
import com.skillforge.app.data.repository.SkillforgeRepository
import com.skillforge.app.utils.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val repository = SkillforgeRepository()
    private val _uiState = MutableStateFlow<UiState<ApiResponse>>(UiState.Loading)
    val uiState: StateFlow<UiState<ApiResponse>> = _uiState
    init {
        loadData()
    }

    fun loadData() {
        viewModelScope.launch {
            try {
                val response = repository.getSkillforgeData()
                _uiState.value = UiState.Success(response)
            } catch (e: Exception) {
                _uiState.value = UiState.Error<Nothing>(e.message ?: "Unknown Error")
            }
        }
    }
}