package com.nurhaq.sumurmulyo.ui.pages

import android.util.Log
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.nurhaq.sumurmulyo.R
import com.nurhaq.sumurmulyo.ui.components.CardFeature
import com.nurhaq.sumurmulyo.ui.components.CardProduct
import com.nurhaq.sumurmulyo.ui.components.CardTransaction
import com.nurhaq.sumurmulyo.ui.components.ShimmerAnimatedItem
import com.nurhaq.sumurmulyo.ui.pages.Home.HomeViewModel
import com.nurhaq.sumurmulyo.ui.theme.*


@Composable
fun HomeScreen(
    navController: NavController,
//    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val viewModel = hiltViewModel<HomeViewModel>()

    val systemUiController: SystemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(Color.White)
    val scrollState = rememberScrollState()

    val transactionState by viewModel.homeState.observeAsState(
        initial = HomeViewModel.TransactionUIState()
    )

    val productState by viewModel.productState.observeAsState(
        initial = HomeViewModel.ProductUIState()
    )

//    Log.e("loading", transactionState.loading.toString())

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
                        text = "Product",
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

                listProduct()

                Spacer(modifier = Modifier.height(16.dp))
                

            }

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

                    if (transactionState.loading && !transactionState.error){
                        Column(
                            modifier = Modifier.fillMaxSize()
                        ){
                            repeat(5){
                                ShimmerAnimatedItem()
                            }
                        }
                    }

                    if (!transactionState.loading && !transactionState.error){
                        transactionState.data?.forEachIndexed { index, transactionResponse ->
                            CardTransaction(
                                title = transactionResponse.description,
                                category = transactionResponse.type,
                                icon = if (transactionResponse.type == "Billing") R.drawable.ic_salary else R.drawable.ic_shopping_bag,
                                price = transactionResponse.price,
                                date = transactionResponse.date
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                        }
                    }
                    if (transactionState.data?.isEmpty() == true && !transactionState.loading) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 12.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                modifier = Modifier.size(120.dp),
                                painter = painterResource(id = R.drawable.ic_no_data),
                                contentDescription = "no data found", tint = purple60,
                            )
                            Spacer(modifier = Modifier.padding(top = 12.dp))
                            Text(
                                text = "Opss no transaction yet?",
                                style = MaterialTheme.typography.h5.copy(fontSize = 18.sp)
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "You have never done a transaction",
                                style = MaterialTheme.typography.h5.copy(color = light10)
                            )


                        }
                    }




//                    CardTransaction(
//                        title = "Subscription on Disney+ Hotstar",
//                        category = "Subscription",
//                        icon = R.drawable.ic_recurring_bill,
//                        price = "Rp 13.000",
//                        date = "8/9/2022"
//                    )
//                    Spacer(modifier = Modifier.height(8.dp))
//                    CardTransaction(
//                        title = "Subscription on Disney+ Hotstar",
//                        category = "Subscription",
//                        icon = R.drawable.ic_recurring_bill,
//                        price = "Rp 13.000",
//                        date = "8/9/2022"
//                    )
//                    Spacer(modifier = Modifier.height(8.dp))
//                    CardTransaction(
//                        title = "Subscription on Disney+ Hotstar",
//                        category = "Subscription",
//                        icon = R.drawable.ic_recurring_bill,
//                        price = "Rp 13.000",
//                        date = "8/9/2022"
//                    )
//                    Spacer(modifier = Modifier.height(8.dp))
//                    CardTransaction(
//                        title = "Subscription on Disney+ Hotstar",
//                        category = "Subscription",
//                        icon = R.drawable.ic_recurring_bill,
//                        price = "Rp 13.000",
//                        date = "8/9/2022"
//                    )
//                    Spacer(modifier = Modifier.height(8.dp))
//                    CardTransaction(
//                        title = "Payment for july",
//                        category = "Salary",
//                        icon = R.drawable.ic_salary,
//                        price = "Rp 97.500",
//                        date = "1/9/2022"
//                    )
//                    Spacer(modifier = Modifier.height(8.dp))
                    Spacer(modifier = Modifier.height(80.dp))
                }
            }

        }
    }
}



@Composable
fun listProduct(){
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(4) {
            CardProduct()
        }


    }
}
