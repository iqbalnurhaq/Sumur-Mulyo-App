package com.nurhaq.sumurmulyo

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.nurhaq.sumurmulyo.navigation.Screen
import com.nurhaq.sumurmulyo.navigation.SetupNavGraph
import com.nurhaq.sumurmulyo.ui.theme.SumurMulyoTheme
import com.nurhaq.sumurmulyo.viewmodel.SplashViewModel

import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@ExperimentalAnimationApi
@ExperimentalPagerApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)
//        installSplashScreen().setKeepOnScreenCondition {
////            !splashViewModel.isLoading.value
//        }

        setContent {
            SumurMulyoTheme {
                val navController = rememberNavController()
                SetupNavGraph(navController = navController, startDestination = Screen.SignIn.route)
            }
        }
    }
}
