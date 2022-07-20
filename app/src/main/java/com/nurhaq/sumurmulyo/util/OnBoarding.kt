package com.nurhaq.sumurmulyo.util

import androidx.annotation.DrawableRes
import com.nurhaq.sumurmulyo.R

sealed class OnBoarding(
    @DrawableRes val image: Int,
    val title: String,
    val description: String
) {
    object First: OnBoarding(
        image = R.drawable.onboard1,
        title = "Gain total control\nof your money",
        description = "Become your own money manager\nand make every cent count"
    )
    object Second: OnBoarding(
        image = R.drawable.onboard2,
        title = "Know where your\nmoney goes",
        description = "Track your transaction easily,\nwith categories and financial report"
    )
    object Third: OnBoarding(
        image = R.drawable.onboard3,
        title = "Planning ahead",
        description = "Setup your budget for each category\nso you in control"
    )
}
