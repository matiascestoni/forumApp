package com.test.forumapp.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun DetailScreen(postId: String, navigatesToHome: () -> Unit) {
    Column {
        Text("Detail Screen")
        Text(postId)
    }
}