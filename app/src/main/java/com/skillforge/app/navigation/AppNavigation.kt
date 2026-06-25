package com.skillforge.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.skillforge.app.ui.detail.DetailScreen
import com.skillforge.app.ui.home.HomeScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) { HomeScreen(navController) }

        composable(Screen.Detail.route) { backStack ->
            val courseId = backStack.arguments?.getString("courseId") ?: ""
            DetailScreen(navController, courseId)
        }
    }
}