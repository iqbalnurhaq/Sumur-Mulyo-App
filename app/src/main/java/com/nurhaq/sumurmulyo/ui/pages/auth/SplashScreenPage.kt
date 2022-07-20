package com.nurhaq.sumurmulyo.ui.pages.auth


import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.nurhaq.sumurmulyo.navigation.Screen
import com.nurhaq.sumurmulyo.ui.theme.light100
import com.nurhaq.sumurmulyo.ui.theme.purple100
import com.nurhaq.sumurmulyo.ui.theme.yellow100
import com.nurhaq.sumurmulyo.viewmodel.SplashViewModel
import kotlinx.coroutines.delay


@Composable
fun SplashScreenPage(
    navController: NavController,
    splashViewModel: SplashViewModel = hiltViewModel()
) {
    val systemUiController: SystemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(Color.Transparent)
    systemUiController.setNavigationBarColor(Color.Transparent)
    systemUiController.setSystemBarsColor(Color.Transparent)
    systemUiController.isNavigationBarVisible = false


    LaunchedEffect(key1 = true){
        delay(1500)
        navController.navigate(splashViewModel.startDestination.value)
    }


    Surface(
        modifier = Modifier
            .fillMaxSize()

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(purple100),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Box (
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
                    ){

                    Box(
                        modifier = Modifier
                            .width(74.dp)
                            .height(74.dp)
                            .background(yellow100, shape = RoundedCornerShape(40.dp))
                            .clip(RoundedCornerShape(40.dp))
                    ) {

                    }
                    Text(
                        text = "Sumur\nMulyo",
                        style = MaterialTheme.typography.h1,
                        textAlign = TextAlign.Center,
                        softWrap = true,
                        color = light100
                    )


            }

        }
    }
}

