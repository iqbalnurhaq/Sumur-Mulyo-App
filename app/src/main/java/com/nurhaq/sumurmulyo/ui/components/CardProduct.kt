package com.nurhaq.sumurmulyo.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.nurhaq.sumurmulyo.R
import com.nurhaq.sumurmulyo.ui.theme.black
import com.nurhaq.sumurmulyo.ui.theme.blue100
import com.nurhaq.sumurmulyo.ui.theme.light60

@Composable
fun CardProduct(){
    Box(
        modifier = Modifier
            .width(150.dp)
            .height(170.dp)
            .background(light60, shape = RoundedCornerShape(CornerSize(16.dp)))
            .clip(RoundedCornerShape(CornerSize(16.dp)))
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top
        ) {
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(0.6f),
                painter = painterResource(id = R.drawable.product_dummy),
                contentDescription = "product image",
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.4f)
                    .padding(horizontal = 10.dp)
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    text = "Pipa Paralon 3cm dan 9cm",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.h3.copy(color = black)
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = "Rp 30.000",
                    style = MaterialTheme.typography.h5.copy(color = blue100)
                )

            }

        }
    }
}