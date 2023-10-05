package com.example.ecommerceappmvvm.presentation.composables.login

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.ecommerceappmvvm.R
import com.example.ecommerceappmvvm.presentation.navigation.screen.AuthScreen

@Composable
fun LoginScreenUI(navController: NavHostController) {
    HomeContent(navController)
}

@Composable
fun HomeContent(navController: NavHostController, viewModel: LoginViewModel = hiltViewModel()) {

    val context = LocalContext.current
    LaunchedEffect(key1 = viewModel.errorMessage){
        if(viewModel.errorMessage != ""){
            Toast.makeText(context, viewModel.errorMessage, Toast.LENGTH_LONG).show()
        }
    }
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.home_background3),
            contentDescription = "background",
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter
                .colorMatrix(ColorMatrix().apply {
                    setToScale(
                        0.5f,
                        0.5f,
                        0.5f,
                        0.8f
                    )
                })
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 100.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .height(150.dp)
                    .width(150.dp),
                painter = painterResource(id = R.drawable.ic_commerce),
                contentDescription = "Logo"
            )
            Text(
                text = stringResource(id = R.string.foodapp).uppercase(),
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Color.White
            )

        }
        Column(
            modifier = Modifier
                .padding(top = 390.dp)
                .verticalScroll(rememberScrollState())
        ) {
            CardHomeUI(modifier = Modifier, hintEmail = stringResource(id = R.string.email),
                hintPassword = stringResource(id = R.string.password),
                email = viewModel.state.email,
                password = viewModel.state.password,
                hideText = true,
                onValueChangeEmail = { viewModel.onEmailInput(it) },
                onValueChangePassword = { viewModel.onPasswordInput(it) },
                onLogin = { viewModel.login() },
                onRegister = { navController.navigate(route = AuthScreen.Register.route) })
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeUIPreview() {
    LoginScreenUI(navController = rememberNavController())
}
