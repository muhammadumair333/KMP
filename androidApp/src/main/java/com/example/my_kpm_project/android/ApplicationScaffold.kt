package com.example.my_kpm_project.android

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.my_kpm_project.android.screens.AboutScreen
import com.example.my_kpm_project.android.screens.ArticlesScreen
import com.example.my_kpm_project.android.screens.Screen
import com.example.my_kpm_project.android.screens.SourceScreen


@Composable
fun ApplicationScaffold() {
    val navController = rememberNavController()
    Scaffold (
       contentWindowInsets = WindowInsets(0)
    ){
        AppNavHost(
            navController = navController,
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        )
    }
}
@Composable
fun AppNavHost(navController: NavHostController,
               modifier: Modifier= Modifier){

    NavHost(
        navController = navController,
        startDestination = Screen.ARTICLES.route,
        modifier = modifier
    ) {
        composable(Screen.ARTICLES.route) {
            ArticlesScreen(
                onSourceButtonClicked = {
                    navController.navigate(Screen.SOURCE.name)
                },
                onAboutButtonClicked = {
                    navController.navigate(Screen.ABOUT.route)
                }
            )
        }
        composable(Screen.SOURCE.name){
            SourceScreen(
                onUpButtonClicked = {
                    navController.popBackStack()
                }
            )
        }

        composable(Screen.ABOUT.route) {
            AboutScreen(
                onUpButtonClicked = {
                    navController.popBackStack()
                }
            )
        }
    }
}