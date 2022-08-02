package com.nurhaq.sumurmulyo.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.nurhaq.sumurmulyo.ui.pages.DashboardPage
import com.nurhaq.sumurmulyo.ui.pages.HomeScreen
import com.nurhaq.sumurmulyo.ui.pages.Order.OrderScreen
import com.nurhaq.sumurmulyo.ui.pages.Profile.ProfileScreen
import com.nurhaq.sumurmulyo.ui.pages.Transaction.TransactionScreen
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


        // Dashboard



//        // Bottom Navigation
//        composable(
//            route = BottomScreen.Home.route
//        ){
//            HomeScreen(navController)
//        }
//        composable(
//            route = BottomScreen.Transaction.route
//        ){
//            TransactionScreen(navController)
//        }
//        composable(
//            route =  BottomScreen.Order.route
//        ){
//            OrderScreen(navController)
//        }
//        composable(
//            route = BottomScreen.Profile.route
//        ){
//            ProfileScreen(navController)
//        }


    }
}