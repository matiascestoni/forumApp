package com.test.forumapp.presentation.screen

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.test.forumapp.presentation.routes.AppNavHost
import com.test.forumapp.presentation.theme.ForumAppTheme

@Composable
fun ForumApp() {
    ForumAppTheme {
        AppNavHost(
            navController = rememberNavController()
        )
    }
}