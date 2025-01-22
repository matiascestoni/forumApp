package com.test.forumapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.test.forumapp.presentation.screen.DetailScreen
import com.test.forumapp.presentation.screen.HomeScreen
import com.test.forumapp.presentation.screen.LoginScreen
import com.test.forumapp.presentation.viewmodel.HomeViewModel
import com.test.forumapp.presentation.viewmodel.LoginViewModel

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Login,
    ) {
        composable<Login> {
            LoginScreen(
                navigateToHome = { navController.navigate(Home) },
                viewModel = LoginViewModel()
            )
        }
        composable<Home>
        {
            HomeScreen(
                { postId -> navController.navigate(Detail(postId)) },
                viewModel = HomeViewModel()
            )
        }
        composable<Detail> { backStackEntry ->
            val detail = backStackEntry.toRoute<Detail>()
            DetailScreen(detail.postId, navigatesToHome = { navController.popBackStack() })
        }
    }
}
