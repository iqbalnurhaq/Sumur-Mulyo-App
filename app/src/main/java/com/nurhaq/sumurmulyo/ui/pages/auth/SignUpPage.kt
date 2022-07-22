package com.nurhaq.sumurmulyo.ui.pages.auth

import android.widget.Space
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.nurhaq.sumurmulyo.ui.components.InputText
import com.nurhaq.sumurmulyo.ui.parts.HeaderNav
import com.nurhaq.sumurmulyo.R
import com.nurhaq.sumurmulyo.components.ButtonText
import com.nurhaq.sumurmulyo.ui.theme.*
import com.nurhaq.sumurmulyo.util.HyperlinkText

@Composable
fun SignUpPage(
    navController: NavController,
) {
    val isChecked = rememberSaveable { mutableStateOf(false) }
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(light100)
    ) {
        Column {
            HeaderNav(
                modifier = Modifier.padding(top = 50.dp),
                title = "Sign Up",
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(top = 50.dp)
            ) {
                UseFormSignUp()
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(top = 20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Check(
                    isChecked = isChecked
                )
                Spacer(modifier = Modifier.width(12.dp))
                HyperlinkText(
                    fullText = "By signing up, you agree to the Terms of Service and Privacy Policy",
                    linkText = listOf("Terms of Service and Privacy Policy"),
                    hyperlinks = listOf("https://google.com"),
                    linkTextDecoration = TextDecoration.None,
                    fontSize = 14.sp,
                    linkTextFontWeight = FontWeight.Medium,
                    linkTextColor = purple100
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(top = 27.dp)
            ) {
                ButtonText(
                    title = "Sign Up",
                    color = purple100,
                    colorText = light100,
                )
                Text(
                    modifier = Modifier
                        .padding(top = 15.dp)
                        .fillMaxWidth(),
                    text = "Or with",
                    style = MaterialTheme.typography.h5.copy(
                        fontWeight = FontWeight.Bold,
                        color = light10
                    ),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(10.dp))
                ButtonText(
                    modifier = Modifier
                        .border(
                            BorderStroke(
                                width = 1.5.dp,
                                color = light60,
                            ),
                            shape = RoundedCornerShape(16.dp)
                        ),
                    title = "Sign Up with Google",
                    color = light100,
                    colorText = dark50,
                    icon = R.drawable.ic_google
                )
                Spacer(modifier = Modifier.height(19.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Already have an account? ",
                        style = MaterialTheme.typography.h3.copy(color = light20),
                        textAlign = TextAlign.Center
                    )
                    ClickableText(
                        text = AnnotatedString(
                            "Login",
                            spanStyle = SpanStyle(
                                textDecoration = TextDecoration.Underline
                            )
                        ),
                        style = MaterialTheme.typography.h3.copy(color = purple100),
                        onClick = {

                        }
                    )

                }
            }

        }
    }
}

@Composable
fun Check(
    isChecked : MutableState<Boolean>
){
    Box(
        modifier = Modifier
            .size(24.dp)
            .border(
                width = 2.5.dp,
                color = purple100,
                shape = RoundedCornerShape(5.dp)
            )
            .background(
                color = if (isChecked.value) purple100 else light100,
                shape = RoundedCornerShape(5.dp)
            )
            .clickable { isChecked.value = !isChecked.value },
    ) {
        Icon(imageVector = Icons.Default.Check, contentDescription = "", tint = light100)
    }
}

@Composable
fun UseFormSignUp(
    loading: Boolean = false,
    modifier: Modifier = Modifier
) {
    val name = rememberSaveable { mutableStateOf("") }
    val email = rememberSaveable { mutableStateOf("") }
    val password = rememberSaveable { mutableStateOf("") }
    val scrollState = rememberScrollState()
    val passwordVisibility = rememberSaveable { mutableStateOf(false) }


    Column(
        modifier = modifier
            .fillMaxWidth()
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        InputText(
            valueState = name,
            placeholder = "Name",
            enabled = !loading,
        )
        Spacer(modifier = Modifier.height(24.dp))
        InputText(
            valueState = email,
            placeholder = "Email",
            enabled = !loading,
            keyboardType = KeyboardType.Email
        )
        Spacer(modifier = Modifier.height(24.dp))
        InputText(
            valueState = password,
            placeholder = "Password",
            enabled = !loading,
            keyboardType = KeyboardType.Password,
            passwordVisibility = passwordVisibility,
            trailingIcon = R.drawable.ic_eye_open
        )
    }


}