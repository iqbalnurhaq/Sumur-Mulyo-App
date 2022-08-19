package com.nurhaq.sumurmulyo.ui.parts

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.nurhaq.sumurmulyo.R
import com.nurhaq.sumurmulyo.ui.theme.Transparent
import com.nurhaq.sumurmulyo.ui.theme.dark50

@Composable
fun HeaderNav(
    modifier: Modifier = Modifier,
    title : String,
    color: Color = dark50
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = title,
                style = MaterialTheme.typography.h4.copy(color = dark50),
                textAlign = TextAlign.Center
            )

        }
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_arrow_left),
                contentDescription = "icon left",
                modifier = Modifier
                    .width(25.dp)
                    .height(25.dp)
            )

        }
    }
}