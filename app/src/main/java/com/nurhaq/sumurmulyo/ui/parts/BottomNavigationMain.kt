package com.nurhaq.sumurmulyo.ui.parts

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.nurhaq.sumurmulyo.R
import com.nurhaq.sumurmulyo.navigation.BottomScreen
import com.nurhaq.sumurmulyo.navigation.Screen
import com.nurhaq.sumurmulyo.ui.theme.gray50
import com.nurhaq.sumurmulyo.ui.theme.light60
import com.nurhaq.sumurmulyo.ui.theme.light80
import com.nurhaq.sumurmulyo.ui.theme.purple100


@Composable
fun AppBottomNavigation(
    navController: NavController,
    bottomNavigationItems: List<BottomScreen>,
){
    var selectedIndex by remember { mutableStateOf(0) }
    BottomNavigation(
        backgroundColor = light60
    ) {
        bottomNavigationItems.forEachIndexed { index, it ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(id = it.icon),
                        contentDescription = it.title,
                        tint = if (selectedIndex == index) purple100 else gray50
                    )
                },
                label = {
                    Text(
                        text = it.title,
                        style = MaterialTheme.typography.h5.copy(fontSize = 12.sp),
                        color = if (selectedIndex == index) purple100 else gray50
                    )
                },
                selected = false,
                selectedContentColor = purple100,
                unselectedContentColor = gray50,
                alwaysShowLabel = true,
                onClick = {
                          when (it.route) {
                              "home" -> {
                                  navController.navigate(BottomScreen.Home.route)
                                  selectedIndex = index
                              }
                              "transaction" -> {
                                  navController.navigate(BottomScreen.Transaction.route)
                                  selectedIndex = index
                              }
                              "order" -> {
                                  navController.navigate(BottomScreen.Order.route)
                                  selectedIndex = index
                              }
                              "profile" -> {
                                  navController.navigate(BottomScreen.Profile.route)
                                  selectedIndex = index
                              }
                          }
                },
            )
        }
    }
}