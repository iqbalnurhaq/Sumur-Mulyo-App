package com.nurhaq.sumurmulyo.ui.pages.Transaction

import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.insets.navigationBarsWithImePadding
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.nurhaq.sumurmulyo.R
import com.nurhaq.sumurmulyo.ui.components.CardTransaction
import com.nurhaq.sumurmulyo.ui.theme.*
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterialApi::class, androidx.compose.foundation.ExperimentalFoundationApi::class)
@Composable
fun TransactionScreen(navController: NavController) {
    val scrollState = rememberScrollState()
    val sheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val coroutineScope = rememberCoroutineScope()
    val listFilterBy = listOf("Salary", "Shopping", "Income", "More")
    val systemUiController: SystemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(Color.White)

    ModalBottomSheetLayout(
        sheetShape = RoundedCornerShape(CornerSize(20.dp)),

        sheetContent = {
            Box(
                modifier = Modifier
                    .navigationBarsWithImePadding()
                    .height(500.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(CornerSize(20.dp)))
                    .background(Color.White, shape = RoundedCornerShape(CornerSize(20.dp))),
            ){
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 16.dp)
                        .padding(horizontal = 16.dp)
                ) {
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Bottom Sheet",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.h5,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Filter Transaction",
                            style = MaterialTheme.typography.h3.copy(color = black)
                        )
                        Box(
                            modifier = Modifier
                                .background(purple20, shape = RoundedCornerShape(CornerSize(40.dp)))
                                .clip(RoundedCornerShape(CornerSize(40.dp))),
                        ){
                            Text(
                                modifier = Modifier.padding(horizontal = 16.dp, vertical = 7.dp),
                                text = "Reset",
                                style = MaterialTheme.typography.h5.copy(color = purple100)

                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Filter By",
                        style = MaterialTheme.typography.h3.copy(color = black)
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    LazyVerticalGrid(
                        cells = GridCells.Adaptive(100.dp),
                        content = {
                            items(listFilterBy.size) { index ->
                                Card(
                                    backgroundColor = Color.White,
                                    elevation = 0.dp,
                                    modifier = Modifier
                                        .padding(horizontal = 4.dp)
                                        .padding(bottom = 4.dp)
                                        .border(1.dp, color = light40, shape = RoundedCornerShape(
                                            CornerSize(24.dp))),
                                    shape = RoundedCornerShape(CornerSize(24.dp))
                                ) {
                                    Text(
                                        maxLines = 1,
                                        textAlign = TextAlign.Center,
                                        modifier = Modifier.padding(horizontal = 20.dp, vertical = 12.dp),
                                        text = listFilterBy[index],
                                        style = MaterialTheme.typography.h5
                                    )
                                }
                            }
                        },
                    )

                }
            }
        },
        sheetState = sheetState,
        sheetBackgroundColor = Color.White
    ) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(scrollState)
                    .padding(horizontal = 16.dp),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 25.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_arrow_left),
                        contentDescription = "arrow left icon"
                    )

                    Text(
                        text = "Transaction",
                        style = MaterialTheme.typography.h5.copy(fontSize = 18.sp)
                    )


                    Box(
                        modifier = Modifier
                            .border(
                                color = light60,
                                width = 2.dp,
                                shape = RoundedCornerShape(CornerSize(10.dp))
                            )
                            .padding(13.dp),

                        ){
                        Icon(
                            painter = painterResource(id = R.drawable.ic_sort),
                            contentDescription = "sort icon",
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Today

                Text(
                    text = "Today",
                    style = MaterialTheme.typography.h4.copy(color = black)
                )

                Spacer(modifier = Modifier.height(8.dp))

                // list Transaction

                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    CardTransaction(
                        title = "Buy some grocery",
                        category = "Shopping",
                        icon = R.drawable.ic_shopping_bag,
                        price = "30000",
                        date = "13:00"
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    CardTransaction(
                        title = "Buy some grocery",
                        category = "Shopping",
                        icon = R.drawable.ic_shopping_bag,
                        price = "30000",
                        date = "13:00"
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    CardTransaction(
                        title = "Buy some grocery",
                        category = "Shopping",
                        icon = R.drawable.ic_shopping_bag,
                        price = "30000",
                        date = "13:00"
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "All Transaction",
                    style = MaterialTheme.typography.h4.copy(color = black)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    CardTransaction(
                        title = "Buy some grocery",
                        category = "Shopping",
                        icon = R.drawable.ic_shopping_bag,
                        price = "30000",
                        date = "13:00"
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    CardTransaction(
                        title = "Buy some grocery",
                        category = "Shopping",
                        icon = R.drawable.ic_shopping_bag,
                        price = "30000",
                        date = "13:00"
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    CardTransaction(
                        title = "Buy some grocery",
                        category = "Shopping",
                        icon = R.drawable.ic_shopping_bag,
                        price = "30000",
                        date = "13:00"
                    )
                    CardTransaction(
                        title = "Buy some grocery",
                        category = "Shopping",
                        icon = R.drawable.ic_shopping_bag,
                        price = "30000",
                        date = "13:00"
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    CardTransaction(
                        title = "Buy some grocery",
                        category = "Shopping",
                        icon = R.drawable.ic_shopping_bag,
                        price = "30000",
                        date = "13:00"
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    CardTransaction(
                        title = "Buy some grocery",
                        category = "Shopping",
                        icon = R.drawable.ic_shopping_bag,
                        price = "30000",
                        date = "13:00"
                    )
                }

                Button(onClick = {
                    coroutineScope.launch {
                        sheetState.show()
                    }
                }) {
                    Text(text = "Click Me")
                }
                Spacer(modifier = Modifier.height(80.dp))
            }
        }
    }

}

//@OptIn(ExperimentalMaterialApi::class)
//@Composable
//fun ModalBottomSheet(sheetState: ModalBottomSheetState){
//
//    val coroutineScope = rememberCoroutineScope()
//    ModalBottomSheetLayout(
//        sheetContent = {
//            Box(
//                modifier = Modifier
//                    .navigationBarsWithImePadding()
//                    .height(200.dp)
//                    .fillMaxWidth()
//                    .background(Color.White),
//            ){
//                Column(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .padding(10.dp)
//                ) {
//                    Text(
//                        text = "Bottom Sheet",
//                        textAlign = TextAlign.Center,
//                        style = MaterialTheme.typography.h5,
//                        fontWeight = FontWeight.Bold,
//                        modifier = Modifier.fillMaxWidth()
//                    )
//                    Text(
//                        text = "Item 1",
//                        style = MaterialTheme.typography.h6,
//                        modifier = Modifier.padding(top = 10.dp)
//                    )
//                    Text(
//                        text = "Item 2",
//                        style = MaterialTheme.typography.h6,
//                        modifier = Modifier.padding(top = 10.dp)
//                    )
//                    Text(
//                        text = "Item 3",
//                        style = MaterialTheme.typography.h6,
//                        modifier = Modifier.padding(top = 10.dp)
//                    )
//                }
//            }
//        },
//        sheetState = sheetState,
//        sheetBackgroundColor = Color.White
//    ) {
//        Column {
//            Box(modifier = Modifier.fillMaxSize()){
//                Button(
//                    onClick = {
//                        coroutineScope.launch {
//                            sheetState.show()
//                        }
//                    },
//                ) {
//                    Text(text = "Click Me", style = MaterialTheme.typography.h5)
//                }
//            }
//        }
//    }
//}