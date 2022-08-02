package com.nurhaq.sumurmulyo.ui.pages

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.AppBarDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.nurhaq.sumurmulyo.navigation.BottomScreen
import com.nurhaq.sumurmulyo.navigation.bottomNavigationItems
import com.nurhaq.sumurmulyo.ui.pages.Order.OrderScreen
import com.nurhaq.sumurmulyo.ui.pages.Profile.ProfileScreen
import com.nurhaq.sumurmulyo.ui.pages.Transaction.TransactionScreen
import com.nurhaq.sumurmulyo.ui.parts.AppBottomNavigation
import com.nurhaq.sumurmulyo.ui.theme.Purple500
import com.nurhaq.sumurmulyo.ui.theme.light60


@Composable
fun DashboardPage(
    navController: NavController
) {
    val systemUiController: SystemUiController = rememberSystemUiController()
    systemUiController.setNavigationBarColor(light60)
//    systemUiController.isNavigationBarVisible = false
//    systemUiController.isSystemBarsVisible = false
//    systemUiController.isStatusBarVisible = false
//    systemUiController.systemBarsDarkContentEnabled = false


    Scaffold(

        bottomBar = {
            AppBottomNavigation(
                navController = navController,
                bottomNavigationItems = bottomNavigationItems,

            )
        }
    ) {
        NavHost(
            navController = navController as NavHostController,
            startDestination = BottomScreen.Home.route
        ) {
            composable(
                route = BottomScreen.Home.route
            ){
                HomeScreen(navController)
            }
            composable(
                route = BottomScreen.Transaction.route
            ){
                TransactionScreen(navController)
            }
            composable(
                route =  BottomScreen.Order.route
            ){
                OrderScreen(navController)
            }
            composable(
                route = BottomScreen.Profile.route
            ){
                ProfileScreen(navController)
            }

        }
    }
}