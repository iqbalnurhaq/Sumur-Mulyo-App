package com.nurhaq.sumurmulyo.ui.pages.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.nurhaq.sumurmulyo.ui.theme.purple100


@Composable
fun SplashScreenPage(
    navController: NavController
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(purple100)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Sumur Mulyo",)
        }
    }
}