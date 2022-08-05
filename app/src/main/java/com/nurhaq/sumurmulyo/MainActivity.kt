package com.nurhaq.sumurmulyo

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.nurhaq.sumurmulyo.navigation.Screen
import com.nurhaq.sumurmulyo.navigation.SetupNavGraph
import com.nurhaq.sumurmulyo.ui.pages.DashboardPage
import com.nurhaq.sumurmulyo.ui.pages.auth.OnBoardingPage
import com.nurhaq.sumurmulyo.ui.pages.auth.SignInPage
import com.nurhaq.sumurmulyo.ui.pages.auth.SignUpPage
import com.nurhaq.sumurmulyo.ui.pages.auth.SplashScreenPage
import com.nurhaq.sumurmulyo.ui.theme.SumurMulyoTheme

import dagger.hilt.android.AndroidEntryPoint

@ExperimentalAnimationApi
@ExperimentalPagerApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        WindowCompat.setDecorFitsSystemWindows(window, false)
//        installSplashScreen().setKeepOnScreenCondition {
////            !splashViewModel.isLoading.value
//        }

        setContent {
            SumurMulyoTheme {
                val navController = rememberNavController()
                val navBarNavController = rememberNavController()
                
                NavHost(
                    navController = navController,
                    startDestination = Screen.Splash.route
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
                        route = Screen.SignUp.route
                    ){
                        SignUpPage(navController)
                    }
                    composable(
                        route = Screen.SignIn.route
                    ){
                        SignInPage(navController)
                    }
                    composable(
                        route = Screen.Dashboard.route
                    ){
                        DashboardPage(navBarNavController)
                    }
                }
//                SetupNavGraph(navController = navController, startDestination = Screen.Dashboard.route)
//                DashboardPage(navController = navController)


            }
        }
    }
}
