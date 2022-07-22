package com.nurhaq.sumurmulyo.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.nurhaq.sumurmulyo.ui.theme.purple100


@Composable
fun ButtonText(
    modifier: Modifier = Modifier,
    title: String,
    color: Color,
    colorText : Color,
    rounded: Dp = 16.dp,
    icon: Int? = null
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(color, shape = RoundedCornerShape(rounded))
            .padding(vertical = 17.dp)
            .clip(RoundedCornerShape(rounded))
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){

            if (icon != null){

                Image(
                    modifier = Modifier.size(32.dp),
                    painter = painterResource(id = icon),
                    contentDescription = "icon button",
                )
                Spacer(modifier = Modifier.width(10.dp))
            }
            Text(
                text = title,
                style = MaterialTheme.typography.h4.copy(color = colorText),
                textAlign = TextAlign.Center,
            )
        }
    }
}