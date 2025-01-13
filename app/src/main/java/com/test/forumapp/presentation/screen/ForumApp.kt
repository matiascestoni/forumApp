package com.test.forumapp.presentation.screen

import androidx.compose.runtime.Composable
import com.test.forumapp.presentation.navigation.NavigationWrapper
import com.test.forumapp.presentation.theme.ForumAppTheme

@Composable
fun ForumApp() {
    ForumAppTheme {
        NavigationWrapper()
    }
}