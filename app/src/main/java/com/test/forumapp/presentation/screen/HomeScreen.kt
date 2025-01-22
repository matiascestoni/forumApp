package com.test.forumapp.presentation.screen

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.test.forumapp.presentation.model.HomeUIState
import com.test.forumapp.presentation.model.Post
import com.test.forumapp.presentation.viewmodel.HomeViewModel

@Composable
fun HomeScreen(navigateToDetail: (String) -> Unit, viewModel: HomeViewModel) {
    val homeUIState by viewModel.homeUIState.collectAsState()
    /*
    LaunchedEffect(key1 = true) {
        Log.d("ZZZ", "LaunchedEffect")
        viewModel.init()
    }

     */

    when (homeUIState) {
        is HomeUIState.Idle -> {}
        is HomeUIState.Loading -> {}
        is HomeUIState.Error -> {}
        is HomeUIState.Success -> ShowPostList(
            modifier = Modifier,
            (homeUIState as HomeUIState.Success).postList,
            navigateToDetail
        )
    }
}

@Composable
fun ShowPostList(
    modifier: Modifier = Modifier,
    postList: List<Post>,
    navigateToDetail: (String) -> Unit
) {
    LazyColumn(modifier = modifier) {
        items(postList.size) {
            Button(onClick = { navigateToDetail(postList[it].postId) }) {
                Text(postList[it].title)
            }
        }
    }
}