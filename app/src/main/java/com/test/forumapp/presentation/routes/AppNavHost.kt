package com.test.forumapp.presentation.routes

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.test.forumapp.presentation.screen.DetailScreen
import com.test.forumapp.presentation.screen.HomeScreen
import com.test.forumapp.presentation.screen.LoginScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = "login",
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(
            "login",
            enterTransition = ::slideInToLeft,
            exitTransition = ::slideOutToLeft,
            popEnterTransition = ::slideInToRight,
            popExitTransition = ::slideOutToRight
        ) {
            LoginScreen(navController = navController)
        }
        composable(
            "home",
            enterTransition = ::slideInToLeft,
            exitTransition = ::slideOutToLeft,
            popEnterTransition = ::slideInToRight,
            popExitTransition = ::slideOutToRight
        ) {
            HomeScreen(navController = navController)
        }
        composable(
            "detail/{postId}",
            enterTransition = ::slideInToLeft,
            exitTransition = ::slideOutToLeft,
            popEnterTransition = ::slideInToRight,
            popExitTransition = ::slideOutToRight
        ) { backStackEntry ->
            val postId = backStackEntry.arguments?.getString("postId")
            DetailScreen(navController = navController, postId = postId)
        }
    }
}

fun slideInToLeft(scope: AnimatedContentTransitionScope<NavBackStackEntry>): EnterTransition {
    return scope.slideIntoContainer(
        AnimatedContentTransitionScope.SlideDirection.Left,
        animationSpec = tween(500)
    )
}

fun slideInToRight(scope: AnimatedContentTransitionScope<NavBackStackEntry>): EnterTransition {
    return scope.slideIntoContainer(
        AnimatedContentTransitionScope.SlideDirection.Right,
        animationSpec = tween(500)
    )
}

fun slideOutToLeft(scope: AnimatedContentTransitionScope<NavBackStackEntry>): ExitTransition {
    return scope.slideOutOfContainer(
        AnimatedContentTransitionScope.SlideDirection.Left,
        animationSpec = tween(500)
    )
}

fun slideOutToRight(scope: AnimatedContentTransitionScope<NavBackStackEntry>): ExitTransition {
    return scope.slideOutOfContainer(
        AnimatedContentTransitionScope.SlideDirection.Right,
        animationSpec = tween(500)
    )
}