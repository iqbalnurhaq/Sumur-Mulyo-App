package com.nurhaq.sumurmulyo.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.nurhaq.sumurmulyo.ui.theme.purple100


@Composable
fun ButtonText(
    title: String,
    color: Color,
    colorText : Color,
    rounded: Dp = 16.dp
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color, shape = RoundedCornerShape(rounded))
            .padding(vertical = 17.dp)
            .clip(RoundedCornerShape(rounded))
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.h4.copy(color = colorText),
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }
}