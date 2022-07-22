package com.nurhaq.sumurmulyo.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.nurhaq.sumurmulyo.ui.pages.HomeScreen
import com.nurhaq.sumurmulyo.ui.pages.auth.OnBoardingPage
import com.nurhaq.sumurmulyo.ui.pages.auth.SignInPage
import com.nurhaq.sumurmulyo.ui.pages.auth.SignUpPage
import com.nurhaq.sumurmulyo.ui.pages.auth.SplashScreenPage


@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
fun SetupNavGraph(
    navController: NavHostController,
    startDestination: String
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ){
        composable(
            route = Screen.Splash.route
        ){
            SplashScreenPage(navController)
        }
        composable(
            route = Screen.OnBoarding.route
        ){
            OnBoardingPage(navController)
        }
        composable(
            route = Screen.Home.route
        ){
            HomeScreen(navController)
        }
        composable(
            route = Screen.SignUp.route
        ){
            SignUpPage(navController)
        }
        composable(
            route = Screen.SignIn.route
        ){
            SignInPage(navController)
        }
    }
}