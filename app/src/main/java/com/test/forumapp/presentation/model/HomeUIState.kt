package com.test.forumapp.presentation.model

sealed class HomeUIState {
    data object Idle : HomeUIState()
    data object Loading : HomeUIState()
    data class Error(val message: String) : HomeUIState()
    data class Success(val postList: List<Post>) : HomeUIState()
}