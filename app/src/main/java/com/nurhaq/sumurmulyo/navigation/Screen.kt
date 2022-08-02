package com.nurhaq.sumurmulyo.navigation

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.vector.ImageVector
import com.nurhaq.sumurmulyo.R

sealed class Screen(val route: String) {
    object Splash: Screen("splash_screen")
    object OnBoarding: Screen("on_boarding")
    object SignUp: Screen("sign_up")
    object SignIn: Screen("sign_in")
    object Dashboard: Screen("dashboard")

}

sealed class BottomScreen (val route: String, val title: String, @DrawableRes val icon: Int){
    object Home: BottomScreen(route = "home", title = "Home", icon = R.drawable.ic_home)
    object Transaction: BottomScreen(route = "transaction", title = "transaction", icon = R.drawable.ic_transaction)
    object Profile: BottomScreen("profile", "Profile", R.drawable.ic_user)
    object Order: BottomScreen("order", "Order", R.drawable.ic_transaction)
}

val bottomNavigationItems = listOf(
    BottomScreen.Home,
    BottomScreen.Transaction,
    BottomScreen.Order,
    BottomScreen.Profile,
)

