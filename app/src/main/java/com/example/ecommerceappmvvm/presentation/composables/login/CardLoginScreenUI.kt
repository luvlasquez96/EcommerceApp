package com.example.ecommerceappmvvm.presentation.composables.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecommerceappmvvm.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardHomeUI(
    modifier: Modifier,
    email: String,
    password: String,
    onValueChangeEmail: (String) -> Unit,
    onValueChangePassword: (String) -> Unit,
    hintEmail: String,
    hintPassword: String,
    hideText: Boolean = false,
    onLogin: () -> Unit,
    onRegister: () -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .height(450.dp),
        shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White.copy(0.7f)),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(),
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = stringResource(id = R.string.get_into).uppercase(),
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 24.dp, top = 14.dp),
                fontSize = 20.sp,
            )
            Column() {
                Row(modifier = Modifier.padding(16.dp)) {
                    Icon(
                        modifier = Modifier
                            .size(70.dp)
                            .clip(shape = CircleShape)
                            .padding(end = 16.dp)
                            .align(Alignment.CenterVertically),
                        painter = painterResource(id = R.drawable.ic_email),
                        contentDescription = "Icon",
                    )
                    Spacer(modifier = Modifier.width(8.dp))

                    TextField(
                        value = email,
                        onValueChange = { onValueChangeEmail(it) },
                        maxLines = 1,
                        colors = TextFieldDefaults.textFieldColors(
                            placeholderColor = Color.Gray,
                            focusedIndicatorColor = Color.Transparent,
                            containerColor = Color.White.copy(0.5f)
                        ),
                        singleLine = true,
                        textStyle = TextStyle(color = Color.Black),
                        placeholder = { Text(text = hintEmail) },
                    )
                }
                Row(modifier = Modifier.padding(16.dp)) {

                    Icon(
                        modifier = Modifier
                            .size(70.dp)
                            .clip(shape = CircleShape)
                            .padding(end = 16.dp)
                            .align(Alignment.CenterVertically),
                        painter = painterResource(id = R.drawable.ic_pass),
                        contentDescription = "Icon",
                    )
                    Spacer(modifier = Modifier.width(8.dp))

                    TextField(
                        value = password,
                        onValueChange = { onValueChangePassword(it) },
                        maxLines = 1,
                        colors = TextFieldDefaults.textFieldColors(
                            placeholderColor = Color.Gray,
                            focusedIndicatorColor = Color.Transparent,
                            containerColor = Color.White.copy(0.5f)
                        ),
                        singleLine = true,
                        textStyle = TextStyle(color = Color.Black),
                        placeholder = { Text(text = hintPassword) },
                        visualTransformation = if (hideText) PasswordVisualTransformation()
                        else VisualTransformation.None
                    )
                }
                Column(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(start = 24.dp, end = 16.dp, bottom = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(32.dp)
                ) {
                    Button(
                        onClick = onLogin,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(62.dp),
                        shape = RoundedCornerShape(20.dp)
                    ) {
                        Text(text = stringResource(id = R.string.login).uppercase())
                    }
                    Row(
                        modifier = Modifier.padding(start = 50.dp),
                        horizontalArrangement = Arrangement.spacedBy(14.dp)
                    ) {
                        Text(
                            text = stringResource(id = R.string.no_account),
                            fontSize = 18.sp
                        )
                        Text(text = stringResource(id = R.string.registration),
                            fontSize = 18.sp,
                            fontStyle = FontStyle.Italic,
                            color = colorResource(id = R.color.icon_green),
                            textDecoration = TextDecoration.Underline,
                            modifier = Modifier.clickable { onRegister() })
                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun CardHomeUIPreview() {
    CardHomeUI(
        modifier = Modifier,
        email = "",
        password = "",
        hintEmail = "Correo electrónico",
        hintPassword = "Contraseña",
        onValueChangeEmail = {},
        onValueChangePassword = {},
        onLogin = {},
        onRegister = {})
}