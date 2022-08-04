package com.nurhaq.sumurmulyo.ui.pages

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.nurhaq.sumurmulyo.R
import com.nurhaq.sumurmulyo.ui.components.CardFeature
import com.nurhaq.sumurmulyo.ui.components.CardTransaction
import com.nurhaq.sumurmulyo.ui.theme.*


@Composable
fun HomeScreen(navController: NavController) {

    val systemUiController: SystemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(Color.White)

    val scrollState = rememberScrollState()
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(scrollState)
                .padding(top = 25.dp),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(50.dp)
                                    .clip(RoundedCornerShape(25.dp))
                                
                            ){
                                Image(
                                    painter = painterResource(id = R.drawable.profile_dummy),
                                    contentDescription = "profile image",
                                    contentScale = ContentScale.Crop
                                )
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            Column{
                                Text(
                                    text = "Hello, ",
                                    style = MaterialTheme.typography.h6.copy(fontSize = 15.sp)
                                )
                                Text(
                                    text = "Iqbal Nur Haq",
                                    style = MaterialTheme.typography.h5.copy(fontSize = 20.sp)
                                )

                            }
                        }
                        Icon(
                            painter = painterResource(id = R.drawable.ic_bell),
                            contentDescription = "Bell Icon",
                            modifier = Modifier.size(23.dp),
                            tint = gray50

                        )
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "October payment",
                style = MaterialTheme.typography.h5.copy(color = light10, fontSize = 15.sp),
                textAlign = TextAlign.Center
            )
            Text(
                modifier = Modifier
                    .padding(top = 4.dp)
                    .fillMaxWidth(),

                text = "Rp. 95.000",
                style = MaterialTheme.typography.h4.copy(color = black, fontSize = 30.sp),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(16.dp))


            Column(
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Features",
                    style = MaterialTheme.typography.h4.copy(color = black)
                )
                Spacer(modifier = Modifier.height(12.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    CardFeature(icon = R.drawable.ic_cart)
                    CardFeature(icon = R.drawable.ic_well)
                    CardFeature(icon = R.drawable.ic_complaint)
                    CardFeature(icon = R.drawable.ic_heart)
                }

            }
            
            Spacer(modifier = Modifier.height(16.dp))

            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Recent Transaction",
                        style = MaterialTheme.typography.h4.copy(color = black)
                    )
                    Box(
                        modifier = Modifier
                            .background(purple20, shape = RoundedCornerShape(CornerSize(30.dp)))
                            .padding(
                                horizontal = 16.dp,
                                vertical = 5.dp
                            )
                            .clip(RoundedCornerShape(CornerSize(30.dp)))
                    ) {
                        Text(
                            text = "See All",
                            style = MaterialTheme.typography.h5.copy(color = purple100)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(12.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {

                    CardTransaction(
                        title = "Buy some grocery", 
                        category = "Shopping", 
                        icon = R.drawable.ic_shopping_bag, 
                        price = "Rp 15.000", 
                        date = "15/9/2022"
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    CardTransaction(
                        title = "Subscription on Disney+ Hotstar",
                        category = "Subscription",
                        icon = R.drawable.ic_recurring_bill,
                        price = "Rp 13.000",
                        date = "8/9/2022"
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    CardTransaction(
                        title = "Subscription on Disney+ Hotstar",
                        category = "Subscription",
                        icon = R.drawable.ic_recurring_bill,
                        price = "Rp 13.000",
                        date = "8/9/2022"
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    CardTransaction(
                        title = "Subscription on Disney+ Hotstar",
                        category = "Subscription",
                        icon = R.drawable.ic_recurring_bill,
                        price = "Rp 13.000",
                        date = "8/9/2022"
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    CardTransaction(
                        title = "Subscription on Disney+ Hotstar",
                        category = "Subscription",
                        icon = R.drawable.ic_recurring_bill,
                        price = "Rp 13.000",
                        date = "8/9/2022"
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    CardTransaction(
                        title = "Payment for july",
                        category = "Salary",
                        icon = R.drawable.ic_salary,
                        price = "Rp 97.500",
                        date = "1/9/2022"
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Spacer(modifier = Modifier.height(80.dp))
                }
            }

        }
    }
}

