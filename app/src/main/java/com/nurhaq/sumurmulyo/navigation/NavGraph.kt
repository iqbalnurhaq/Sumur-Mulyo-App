package com.nurhaq.sumurmulyo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nurhaq.sumurmulyo.ui.pages.auth.SplashScreenPage


@Composable
fun SetupNavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ){
        composable(
            route = Screen.Splash.route
        ){
            SplashScreenPage(navController)
        }
    }
}