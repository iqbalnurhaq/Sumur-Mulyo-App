package com.nurhaq.sumurmulyo.navigation

sealed class Screen(val route: String) {
    object Splash: Screen("splash_screen")
    object Home: Screen("home_screen")
    object OnBoarding: Screen("on_boarding")

}