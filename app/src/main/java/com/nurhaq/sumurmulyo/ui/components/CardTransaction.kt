package com.nurhaq.sumurmulyo.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nurhaq.sumurmulyo.R
import com.nurhaq.sumurmulyo.ui.theme.*


@Composable
fun CardTransaction(
    title: String,
    category: String,
    @DrawableRes icon: Int,
    price: String,
    date: String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(light60, shape = RoundedCornerShape(CornerSize(24.dp)))
            .clip(RoundedCornerShape(CornerSize(24.dp)))
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 14.dp)
                .fillMaxWidth()
                .background(light80, shape = RoundedCornerShape(CornerSize(24.dp))),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Row(
                modifier = Modifier.weight(0.7f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .background(
                            if (category == "Subscription") purple20 else if(category == "Shopping") yellow20 else if (category == "Salary") teal20  else yellow20,
                            shape = RoundedCornerShape(CornerSize(16.dp))
                        )
                        .padding(15.dp)
                        .clip(RoundedCornerShape(CornerSize(16.dp)))
                ){
                    Icon(
                        painter = painterResource(id = icon),
                        contentDescription = "recent item icon",
                        modifier = Modifier.size(30.dp),
                        tint = if (category == "Subscription") purple100 else if(category == "Shopping") yellow100 else if (category == "Salary") teal100 else yellow100
                    )
                }
                Spacer(modifier = Modifier.width(9.dp))
                Column {
                    Text(
                        text = category,
                        style = MaterialTheme.typography.h3.copy(dark75)
                    )
                    Text(
                        text = title,
                        style = MaterialTheme.typography.h3.copy(light10, fontSize = 14.sp),
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1
                    )
                }
            }

            Column(
                modifier = Modifier.weight(0.3f),
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = price,
                    style = MaterialTheme.typography.h3.copy(color = Color(0xFFFD3C4A))
                )

                Text(
                    text = date,
                    style = MaterialTheme.typography.h3.copy(color = light10, fontSize = 13.sp)
                )

            }

        }
    }
}