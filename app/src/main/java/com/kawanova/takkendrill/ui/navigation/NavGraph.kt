package com.kawanova.takkendrill.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kawanova.takkendrill.ui.HomeScreen
import com.kawanova.takkendrill.ui.QuizScreen
import com.kawanova.takkendrill.ui.TakkenCheatScreen
import com.kawanova.takkendrill.ui.TakkenViewModel
import com.kawanova.takkendrill.ui.TakkenVisualizerScreen

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Quiz : Screen("quiz")
    object Visualizer : Screen("visualizer")
    object CheatSheet : Screen("cheatsheet")
}

@Composable
fun NavGraph(
    viewModel: TakkenViewModel,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier
    ) {
        composable(Screen.Home.route) {
            HomeScreen(
                viewModel = viewModel,
                onNavigateToQuiz = { navController.navigate(Screen.Quiz.route) },
                onNavigateToVisualizer = { navController.navigate(Screen.Visualizer.route) },
                onNavigateToCheatSheet = { navController.navigate(Screen.CheatSheet.route) }
            )
        }
        composable(Screen.Quiz.route) {
            QuizScreen(
                viewModel = viewModel,
                onNavigateBack = { navController.popBackStack() }
            )
        }
        composable(Screen.Visualizer.route) {
            TakkenVisualizerScreen(
                viewModel = viewModel,
                onNavigateBack = { navController.popBackStack() }
            )
        }
        composable(Screen.CheatSheet.route) {
            TakkenCheatScreen(
                viewModel = viewModel,
                onNavigateBack = { navController.popBackStack() }
            )
        }
    }
}
