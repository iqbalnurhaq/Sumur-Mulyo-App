package com.nurhaq.sumurmulyo.ui.pages.Complaint

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.nurhaq.sumurmulyo.R
import com.nurhaq.sumurmulyo.ui.theme.*


@Composable
fun ComplaintScreen(
    navController: NavController
) {

    val systemUiController: SystemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(Color.White)
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(top = 30.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_arrow_left),
                    contentDescription = "icon left",
                    modifier = Modifier
                        .width(25.dp)
                        .height(25.dp)
                )

                Text(
                    text = "Complaint",
                    style = MaterialTheme.typography.h4.copy(color = dark50),
                    textAlign = TextAlign.Center
                )

                Box(
                    modifier = Modifier
                        .background(purple100, shape = RoundedCornerShape(CornerSize(10.dp)))
                        .padding(7.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_plus),
                        contentDescription = "icon plus",
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(24.dp))


            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
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
                        Column(
                            modifier = Modifier.weight(0.7f)
                        ) {
                            Text(
                                text = "ini title dari sebuaah comlaint yang diajuakn",
                                style = MaterialTheme.typography.h3.copy(dark75),
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                            Text(
                                text = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).",
                                style = MaterialTheme.typography.h3.copy(light10, fontSize = 12.sp),
                                overflow = TextOverflow.Ellipsis,
                                maxLines = 2,
                            )
                        }

                        Column(
                            modifier = Modifier.weight(0.3f),
                            horizontalAlignment = Alignment.End
                        ) {
                            Text(
                                textAlign = TextAlign.End,
                                text = "Finish",
                                style = MaterialTheme.typography.h3.copy(color = teal100)
                            )

                            Text(
                                textAlign = TextAlign.End,
                                text = "10/08/2022",
                                style = MaterialTheme.typography.h3.copy(color = light10, fontSize = 13.sp)
                            )

                        }

                    }
                }

            }
        }
    }
}