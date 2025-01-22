package com.test.forumapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.forumapp.presentation.model.HomeUIState
import com.test.forumapp.presentation.model.Post
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val _homeUIState = MutableStateFlow<HomeUIState>(HomeUIState.Idle)
    val homeUIState: StateFlow<HomeUIState> = _homeUIState

    init {
        viewModelScope.launch {
            _homeUIState.value = HomeUIState.Loading
            val postList = listOf(
                Post("1", "Post 1"),
                Post("2", "Post 2"),
                Post("3", "Post 3"),
                Post("4", "Post 4"),
                Post("5", "Post 5"),
                Post("6", "Post 6"),
                Post("7", "Post 7"),
                Post("8", "Post 8"),
                Post("9", "Post 9"),
                Post("10", "Post 10"),
                Post("11", "Post 11"),
                Post("12", "Post 12")
            )
            _homeUIState.value = HomeUIState.Success(postList)
        }
    }
}