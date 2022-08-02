package com.nurhaq.sumurmulyo.ui.pages.auth

import android.util.Log
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.nurhaq.sumurmulyo.components.ButtonText
import com.nurhaq.sumurmulyo.navigation.Screen
import com.nurhaq.sumurmulyo.ui.theme.Purple200
import com.nurhaq.sumurmulyo.ui.theme.light20
import com.nurhaq.sumurmulyo.ui.theme.purple100
import com.nurhaq.sumurmulyo.ui.theme.purple20
import com.nurhaq.sumurmulyo.util.OnBoarding


@ExperimentalPagerApi
@Composable
fun OnBoardingPage(
    navController: NavController,
) {
    val pages = listOf(
        OnBoarding.First,
        OnBoarding.Second,
        OnBoarding.Third
    )

    val pagerState = rememberPagerState()
    val systemUiController: SystemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(purple100)
    systemUiController.setNavigationBarColor(Color.Transparent)

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        HorizontalPager(
            count = 3,
            modifier = Modifier.weight(6f),
            state = pagerState,
            verticalAlignment = Alignment.Top,
        ) { position ->
            PagerScreen(onBoarding = pages[position])
        }
//        HorizontalPagerIndicator(
//            modifier = Modifier
//                .align(Alignment.CenterHorizontally)
//                .weight(1f),
//            pagerState = pagerState,
//            activeColor = purple100,
//            indicatorWidth = 16.dp,
//            indicatorHeight = 16.dp,
//            inactiveColor = Color(0xffEEE5FF),
//        )

        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Indicators(size = 3, index = pagerState.currentPage)
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(3f)
                .padding(horizontal = 20.dp),
        ) {
            Spacer(modifier = Modifier.height(25.dp))
            ButtonText(
                modifier = Modifier
                    .clickable{
                        navController.navigate(route = Screen.SignUp.route)
                    },
                title = "Sign Up",
                color = purple100,
                colorText = light20,
            )
            Spacer(modifier = Modifier.height(16.dp))
            ButtonText(
                title = "Login",
                color = purple20,
                colorText = purple100
            )
        }

    }
}


@Composable
fun Indicators(size: Int, index: Int){

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        repeat(size){
            Indicator(isSelected = it == index)
        }
    }
}

@Composable
fun Indicator(isSelected: Boolean) {
    val width = animateDpAsState(
        targetValue = if (isSelected) 18.dp else 8.dp,
        animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy)
    )
    
    Box(
        modifier = Modifier
            .height(width.value)
            .padding(horizontal = 6.dp)
            .width(width.value)
            .clip(CircleShape)
            .background(if (isSelected) purple100 else Color(0xffEEE5FF)),
    )
}

@Composable
fun PagerScreen(
    onBoarding: OnBoarding
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .fillMaxHeight(0.7f),
            painter = painterResource(id = onBoarding.image),
            contentDescription = "Image"
        )
        Column(
            modifier = Modifier.weight(0.3f)
        ) {

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = onBoarding.title,
                style = MaterialTheme.typography.h1,
                textAlign = TextAlign.Center
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                text = onBoarding.description,
                style = MaterialTheme.typography.h3,
                textAlign = TextAlign.Center
            )
        }
    }
}