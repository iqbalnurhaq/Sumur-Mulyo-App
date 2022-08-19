package com.nurhaq.sumurmulyo.ui.pages.Profile

import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.nurhaq.sumurmulyo.R
import com.nurhaq.sumurmulyo.ui.components.CardProfile
import com.nurhaq.sumurmulyo.ui.theme.*


@Composable
fun ProfileScreen(navController: NavController) {

    val scrollState = rememberScrollState()
    Surface(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier.weight(0.9f),
                   verticalAlignment = Alignment.CenterVertically 
                ) {
                    Box(
                        modifier = Modifier
                            .background(Color.White, shape = RoundedCornerShape(CornerSize(40.dp)))
                            .clip(RoundedCornerShape(CornerSize(40.dp)))
                            .border(
                                BorderStroke(2.dp, purple100),
                                shape = RoundedCornerShape(CornerSize(40.dp))
                            )
                            .size(85.dp)
                    ) {
                        Image(
                            modifier = Modifier
                                .padding(5.dp)
                                .clip(RoundedCornerShape(CornerSize(40.dp))),
                            painter = painterResource(id = R.drawable.profile_dummy),
                            contentDescription = "profile image",
                            contentScale = ContentScale.Crop
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Column(
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Username",
                            style = MaterialTheme.typography.h5.copy(color = gray50)
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = "Iqbal Nur Haq Binkidi",
                            style = MaterialTheme.typography.subtitle1,
                        )
                    }
                }

                Image(
                    modifier = Modifier
                        .size(20.dp)
                        .weight(0.1f),
                    painter = painterResource(id = R.drawable.ic_pen),
                    contentDescription = "pen icon",
                )
            }
            
            Spacer(modifier = Modifier.height(40.dp))


            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(background, shape = RoundedCornerShape(CornerSize(24.dp)))
                    .clip(RoundedCornerShape(CornerSize(24.dp)))

            ) {
                CardProfile(
                    title = "Account",
                    icon = R.drawable.ic_wallet
                )
                Divider(color = Color.White, thickness = 2.dp)
                CardProfile(
                    title = "Subscriber",
                    icon = R.drawable.ic_file
                )
                Divider(color = Color.White, thickness = 2.dp)
                CardProfile(
                    title = "Setting",
                    icon = R.drawable.ic_settings
                )
                Divider(color = Color.White, thickness = 2.dp)
                CardProfile(
                    title = "Logout",
                    icon = R.drawable.ic_logout,
                    color = red20
                )
            }
        }
    }
}