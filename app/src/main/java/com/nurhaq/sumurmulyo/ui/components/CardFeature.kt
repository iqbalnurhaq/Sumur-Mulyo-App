package com.nurhaq.sumurmulyo.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.nurhaq.sumurmulyo.R
import com.nurhaq.sumurmulyo.ui.theme.blue100
import com.nurhaq.sumurmulyo.ui.theme.light60


@Composable
fun CardFeature(
    @DrawableRes icon: Int
) {
    Box(
        modifier = Modifier
            .background(light60, shape = RoundedCornerShape(CornerSize(16.dp)))
            .size(65.dp)
            .clip(RoundedCornerShape(CornerSize(16.dp))),
        contentAlignment = Alignment.Center
    ){
        Icon(
            painter = painterResource(id = icon),
            contentDescription = "feature icon",
            tint = blue100,
        )
    }
}