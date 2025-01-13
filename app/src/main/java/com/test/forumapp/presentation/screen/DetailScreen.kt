package com.test.forumapp.presentation.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun DetailScreen(postId: String, navigatesToHome: () -> Unit) {
    Text("Detail Screen")
    Text(postId)
}