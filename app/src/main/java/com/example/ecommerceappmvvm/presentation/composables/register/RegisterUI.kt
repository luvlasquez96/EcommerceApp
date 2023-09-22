package com.example.ecommerceappmvvm.presentation.composables.register

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
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
import com.example.ecommerceappmvvm.presentation.composables.components.textfield.TopAppBarComp
import com.example.ecommerceappmvvm.presentation.composables.login.LoginViewModel

@Composable
fun RegisterScreenUI(
    navController: NavHostController,
) {
    TopAppBarComp(
        title = stringResource(id = R.string.register),
        isIconAvailable = true,
        navController = navController
    )
    RegisterContent()
}

@Composable
fun RegisterContent(viewModel: RegisterViewModel = hiltViewModel()) {

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
                .padding(top = 58.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .height(120.dp)
                    .width(120.dp),
                painter = painterResource(id = R.drawable.ic_register),
                contentDescription = "register"
            )
            Text(
                text = stringResource(id = R.string.add_information).uppercase(),
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color.White
            )

        }
        Column(modifier = Modifier.padding(top = 218.dp)) {
            CardRegisterScreenUI(
                modifier = Modifier,
                hintName = stringResource(id = R.string.userName),
                hintLastName = stringResource(id = R.string.userLastName),
                hintEmail = stringResource(id = R.string.email),
                hintPhone = stringResource(id = R.string.userPhoneNumber),
                hintPassword = stringResource(id = R.string.password),
                hintPasswordConfirmation = stringResource(id = R.string.passwordConfirmation),
                email = viewModel.state.email,
                password = viewModel.state.password,
                passwordConfirmation = viewModel.state.passwordConfirmation,
                lastName = viewModel.state.lastName,
                phone = viewModel.state.phone,
                name = viewModel.state.name,
                onValueChangeEmail = {viewModel.onEmailInput(it)},
                onValueChangePassword = {viewModel.onPasswordInput(it)},
                onNameChange = {viewModel.onNameInput(it)},
                onLastNameChange = {viewModel.onLastNameInput(it)},
                onPhoneChange = {viewModel.onPhoneInput(it)},
                onValueChangePasswordConfirmation = {viewModel.onPasswordConfirmationInput(it)}

            ) {
                viewModel.validState()
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun RegisterScreenPreview() {
    RegisterScreenUI(navController = rememberNavController())
}
