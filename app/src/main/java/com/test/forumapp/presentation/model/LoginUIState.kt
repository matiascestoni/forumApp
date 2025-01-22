package com.test.forumapp.presentation.model

sealed class LoginUIState {
    data object Idle : LoginUIState()
    data object Loading : LoginUIState()
    data class Error(val message: String) : LoginUIState()
    data object Success : LoginUIState()
}