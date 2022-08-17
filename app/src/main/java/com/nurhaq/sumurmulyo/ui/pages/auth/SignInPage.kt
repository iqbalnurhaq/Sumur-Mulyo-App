package com.nurhaq.sumurmulyo.ui.pages.auth

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.nurhaq.sumurmulyo.ui.components.InputText
import com.nurhaq.sumurmulyo.ui.parts.HeaderNav
import com.nurhaq.sumurmulyo.ui.theme.light100
import com.nurhaq.sumurmulyo.R
import com.nurhaq.sumurmulyo.components.ButtonText
import com.nurhaq.sumurmulyo.navigation.Screen
import com.nurhaq.sumurmulyo.ui.theme.light20
import com.nurhaq.sumurmulyo.ui.theme.purple100


@Composable
fun SignInPage(
    navController: NavController,
    authViewModel: AuthViewModel = hiltViewModel()
) {
    val scrollState = rememberScrollState()
    val ctx = LocalContext.current

    val viewModel = hiltViewModel<AuthViewModel>()

    val loginState by viewModel.loginState.observeAsState(
        initial = AuthViewModel.LoginUIState()
    )



    fun processAuth(email: String, password: String) {
        if (email.isNotBlank() || password.isNotBlank()){
            Log.e("loading", loginState.loading.toString())
            authViewModel.login(email, password){ success, userHasComplete, message ->
                Log.e("loading", loginState.loading.toString())
                Toast.makeText(ctx, message, Toast.LENGTH_LONG).show()
                if (success && userHasComplete) {
                    Log.e("Message", "success and complete")
                    navController.navigate(Screen.Dashboard.route)
                }
                if (success && !userHasComplete) {
                    Log.e("Message", "success and not complete")
                }
            }
        }else{
            Log.e("Err", "err")
        }
    }


    val email = rememberSaveable { mutableStateOf("") }
    val password = rememberSaveable { mutableStateOf("") }
    val passwordVisibility = rememberSaveable { mutableStateOf(false) }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(light100)
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
                .padding(horizontal = 16.dp)
        ) {
            HeaderNav(
                title = "Sign In",
                modifier = Modifier.padding(top = 50.dp)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 50.dp)
            ) {
                UseFormSignIn(
                    email = email,
                    password = password,
                    passwordVisibility = passwordVisibility
                )
            }
            Spacer(modifier = Modifier.height(40.dp))
            ButtonText(
                title = "Sign In",
                color = purple100,
                colorText = light100,
                modifier = Modifier.clickable {
                   processAuth(email = email.value, password = password.value)
//                    navController.navigate(Screen.Dashboard.route)
                },
                loading = loginState.loading
            )
            Spacer(modifier = Modifier.height(35.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Don’t have an account yet? ",
                    style = MaterialTheme.typography.h3.copy(color = light20),
                    textAlign = TextAlign.Center
                )
                ClickableText(
                    text = AnnotatedString(
                        "Sign Up",
                        spanStyle = SpanStyle(
                            textDecoration = TextDecoration.Underline
                        )
                    ),
                    style = MaterialTheme.typography.h3.copy(color = purple100),
                    onClick = {
                        navController.navigate(Screen.SignUp.route)
                    }
                )

            }
            Spacer(modifier = Modifier.height(150.dp))
        }
    }
}


@Composable
fun UseFormSignIn(
    loading: Boolean = false,
    modifier: Modifier = Modifier,
    email : MutableState<String>,
    password: MutableState<String>,
    passwordVisibility: MutableState<Boolean>
) {



    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        InputText(
            valueState = email,
            placeholder = "Email",
            enabled = !loading,
            keyboardType = KeyboardType.Email
        )
        Spacer(modifier = Modifier.height(24.dp))
        InputText(valueState = password,
            placeholder = "Password",
            enabled = !loading,
            keyboardType = KeyboardType.Password,
            passwordVisibility = passwordVisibility,
            trailingIcon = R.drawable.ic_eye_open
        )
    }

}