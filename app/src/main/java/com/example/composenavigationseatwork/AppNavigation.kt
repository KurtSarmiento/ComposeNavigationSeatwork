package com.example.composenavigationseatwork

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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
                onNavigate = {studentId, name, course, year ->
                    navController.navigate(Screen.Details.createRoute(studentId, name, course, year))
                }
            )
        }
        composable(Screen.Details.route,
            arguments = listOf(
                navArgument(name = "studentId"){ type = NavType.StringType },
                navArgument(name = "name"){ type = NavType.StringType },
                navArgument(name = "course"){ type = NavType.StringType },
                navArgument(name = "year"){ type = NavType.StringType },
            )
        ) { backStackEntry ->
                val studentId = backStackEntry.arguments?.getString("studentId")
                val name = backStackEntry.arguments?.getString("name")
                val course = backStackEntry.arguments?.getString("course")
                val year = backStackEntry.arguments?.getString("year")
            DetailsScreen(
                studentId = studentId,
                name = name,
                course = course,
                year = year,
                onBack = { navController.popBackStack() }
            )
        }
    }
}