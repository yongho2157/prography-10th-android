package com.example.prography_10th_android.feature.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.prography_10th_android.core.common.Result
import com.example.prography_10th_android.core.domain.usecase.DeleteBookmarkUseCase
import com.example.prography_10th_android.core.domain.usecase.GetBookmarkedPhotoByIdUseCase
import com.example.prography_10th_android.core.domain.usecase.GetUnsplashPhotoDetailUseCase
import com.example.prography_10th_android.core.domain.usecase.SaveBookmarkUseCase
import com.example.prography_10th_android.core.model.UnsplashPhotoDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed interface DetailUiState {
    data object Loading : DetailUiState
    data class HasDetailPhoto(val detailPhoto: UnsplashPhotoDetail) : DetailUiState
    data object Error : DetailUiState
}

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getBookmarkedPhotoByIdUseCase: GetBookmarkedPhotoByIdUseCase,
    private val getUnsplashPhotoDetailUseCase: GetUnsplashPhotoDetailUseCase,
    private val saveBookmarkUseCase: SaveBookmarkUseCase,
    private val deleteBookmarkUseCase: DeleteBookmarkUseCase
) : ViewModel() {

    private val _detailUiState: MutableStateFlow<DetailUiState> =
        MutableStateFlow(DetailUiState.Loading)
    val detailUiState = _detailUiState.asStateFlow()

    private val _isBookmarked = MutableStateFlow(false)
    val isBookmarked: StateFlow<Boolean> = _isBookmarked.asStateFlow()

    fun fetchDetailPhoto(id: String) {
        viewModelScope.launch {
            _detailUiState.value = DetailUiState.Loading
            val bookmarkPhotoDetail = getBookmarkedPhotoByIdUseCase(id).first()

            if (bookmarkPhotoDetail != null) {
                // 북마크가 있으면 해당 데이터로 UI 업데이트
                _detailUiState.value = DetailUiState.HasDetailPhoto(detailPhoto = bookmarkPhotoDetail)
                _isBookmarked.value = true
            } else {
                // 북마크가 없으면 데이터 요청
                getUnsplashPhotoDetailUseCase(id).collect { result ->
                    when (result) {
                        is Result.Loading -> {
                            _detailUiState.value = DetailUiState.Loading
                        }
                        is Result.Success -> {
                            _detailUiState.value = DetailUiState.HasDetailPhoto(detailPhoto = result.data)
                            _isBookmarked.value = false
                        }
                        is Result.Error -> {
                            _detailUiState.value = DetailUiState.Error
                        }
                    }
                }
            }
        }
    }


    fun toggleBookmark(detailPhoto: UnsplashPhotoDetail) {
        viewModelScope.launch {
            if (_isBookmarked.value) {
                deleteBookmarkUseCase(detailPhoto.id)
                _isBookmarked.value = false
            } else {
                saveBookmarkUseCase(detailPhoto)
                _isBookmarked.value = true
            }
        }
    }
}
