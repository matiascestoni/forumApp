package com.test.forumapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.forumapp.presentation.model.LoginUIState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    private val _loginState = MutableStateFlow<LoginUIState>(LoginUIState.Idle)
    val loginState: StateFlow<LoginUIState> = _loginState

    fun login(username: String, password: String) = viewModelScope.launch {
        _loginState.value = LoginUIState.Loading
        delay(1000)
        if (username == "test" && password == "test") {
            _loginState.value = LoginUIState.Success
        } else {
            _loginState.value = LoginUIState.Error("Invalid username or password")
        }
    }
}