package com.test.forumapp.presentation.screen

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun HomeScreen(navigateToDetail: (String) -> Unit) {
    Text("Home Screen")
    Button(onClick = { navigateToDetail("123") }) {
        Text("Go to Detail")
    }

}