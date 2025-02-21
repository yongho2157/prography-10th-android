package com.example.prography_10th_android.feature.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.prography_10th_android.core.common.Result
import com.example.prography_10th_android.core.domain.usecase.GetUnsplashPhotoDetailUseCase
import com.example.prography_10th_android.core.model.UnsplashPhotoDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed interface DetailUiState {

    data object Loading: DetailUiState
    data class HasDetailPhoto(val detailPhoto: UnsplashPhotoDetail) : DetailUiState
    data object Error: DetailUiState

}

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getUnsplashPhotoDetailUseCase: GetUnsplashPhotoDetailUseCase
) : ViewModel() {

    private val _detailUiState: MutableStateFlow<DetailUiState> =
        MutableStateFlow(DetailUiState.Loading)
    val detailUiState = _detailUiState.asStateFlow()


    fun fetchDetailPhoto(id: String) {
        viewModelScope.launch {
            getUnsplashPhotoDetailUseCase(id)
                .onEach { result ->
                    when (result) {
                        is Result.Loading -> {
                            _detailUiState.value = DetailUiState.Loading
                        }

                        is Result.Success -> {
                            _detailUiState.value = DetailUiState.HasDetailPhoto(result.data)
                        }

                        is Result.Error -> {
                            _detailUiState.value = DetailUiState.Error
                        }
                    }
                }.launchIn(viewModelScope)
        }
    }
}
