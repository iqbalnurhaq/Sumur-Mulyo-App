package com.nurhaq.sumurmulyo.ui.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.nurhaq.sumurmulyo.ui.theme.*
import com.nurhaq.sumurmulyo.R

@Composable
fun InputText(
    modifier: Modifier = Modifier,
    valueState: MutableState<String>,
    placeholder: String,
    enabled: Boolean,
    isSingleLine: Boolean = true,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    onAction: KeyboardActions = KeyboardActions.Default,
    passwordVisibility: MutableState<Boolean> = mutableStateOf(false),
    trailingIcon: Int? = null,
) {

    val visualTransformation = if (keyboardType != KeyboardType.Password) VisualTransformation.None else if (passwordVisibility.value) VisualTransformation.None else PasswordVisualTransformation()
    val visiblePass = passwordVisibility.value
    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(
                color = light60,
                shape = RoundedCornerShape(16.dp)
            ),
        textStyle = MaterialTheme.typography.h3.copy(color = dark75, fontWeight = FontWeight.Normal),
        shape = RoundedCornerShape(16.dp),
        value = valueState.value,
        onValueChange = { valueState.value = it },
        placeholder = {
            Text(
                text = placeholder,
                style = MaterialTheme.typography.h3.copy(color = light10, fontWeight = FontWeight.Normal)
            )
        },
        singleLine = isSingleLine,
        enabled = enabled,
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = light70,
            unfocusedIndicatorColor = light70,
            disabledIndicatorColor = light70,
            backgroundColor = light100,
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = imeAction
        ),
        keyboardActions = onAction,
        visualTransformation = visualTransformation,
        trailingIcon = {
            if (trailingIcon != null) @Composable {
                IconButton(
                    onClick = {
                        if (keyboardType == KeyboardType.Password) passwordVisibility.value = !visiblePass
                    },
                ) {
                    if (passwordVisibility.value) {
                        Image(
                            modifier = Modifier
                                .width(22.dp)
                                .height(15.dp),
                            painter = painterResource(id = R.drawable.ic_eye),
                            contentDescription = "icon",
                        )
                    }
                    else {
                        Image(
                            modifier = Modifier
                                .width(22.dp)
                                .height(15.dp),
                            painter = painterResource(id = trailingIcon),
                            contentDescription = "icon",
                        )
                    }
                }
            }
            else false
        }
    )
}

