package com.example.prography_10th_android.feature.random

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.prography_10th_android.core.common.Result
import com.example.prography_10th_android.core.domain.usecase.GetUnsplashRandomPhotoUseCase
import com.example.prography_10th_android.core.domain.usecase.SaveBookmarkUseCase
import com.example.prography_10th_android.core.model.UnsplashPhoto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed interface RandomUiState {
    data object Loading : RandomUiState
    data class HasRandomPhoto(val photo: UnsplashPhoto) : RandomUiState
    data object Error : RandomUiState
}

@HiltViewModel
class RandomViewModel @Inject constructor(
    private val getUnsplashRandomPhotoUseCase: GetUnsplashRandomPhotoUseCase,
) : ViewModel() {
    private val _randomUiState: MutableStateFlow<RandomUiState> =
        MutableStateFlow(RandomUiState.Loading)

    val randomUiState = _randomUiState.asStateFlow()

    fun fetchRandomPhoto() {
        viewModelScope.launch {
            getUnsplashRandomPhotoUseCase().collect { result ->
                when (result) {
                    is Result.Loading -> {
                        _randomUiState.value = RandomUiState.Loading
                    }

                    is Result.Success -> {
                        _randomUiState.value = RandomUiState.HasRandomPhoto(photo = result.data)
                    }

                    is Result.Error -> {
                        _randomUiState.value = RandomUiState.Error

                    }
                }
            }
        }
    }
}


