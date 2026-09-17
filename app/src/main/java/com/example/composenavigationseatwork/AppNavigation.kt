package com.example.composenavigationseatwork

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composenavigationseatwork.screens.Screen
import com.example.composenavigationseatwork.screens.details.DetailsScreen
import com.example.composenavigationseatwork.screens.home.HomeScreen


@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier
    ) {
        composable(Screen.Home.route) {
            HomeScreen(
                onNavigate = { navController.navigate(Screen.Details.route) }
            )
        }
        composable(Screen.Details.route) {
            DetailsScreen(
                onBack = { navController.popBackStack() }
            )
        }
    }
}