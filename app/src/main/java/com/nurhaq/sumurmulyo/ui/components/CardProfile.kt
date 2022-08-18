package com.nurhaq.sumurmulyo.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.nurhaq.sumurmulyo.ui.theme.black
import com.nurhaq.sumurmulyo.ui.theme.purple20

@Composable
fun CardProfile(
    title: String,
    @DrawableRes icon: Int,
    color : Color = purple20
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(18.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .background(color, shape = RoundedCornerShape(CornerSize(16.dp)))
                .clip(RoundedCornerShape(CornerSize(16.dp)))
        ) {
            Image(
                modifier = Modifier
                    .padding(14.dp)
                    .size(24.dp),
                painter = painterResource(id = icon),
                contentDescription = "wallet icon",
            )
        }

        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = title,
            style = MaterialTheme.typography.h3.copy(color = black)
        )
    }
}