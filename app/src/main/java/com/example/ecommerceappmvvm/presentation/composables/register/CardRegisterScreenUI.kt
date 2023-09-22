package com.example.ecommerceappmvvm.presentation.composables.register

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecommerceappmvvm.R
import com.example.ecommerceappmvvm.presentation.composables.components.textfield.Textfield
import com.example.ecommerceappmvvm.ui.theme.Orange80

@Composable
fun CardRegisterScreenUI(
    modifier: Modifier,
    name: String,
    lastName: String,
    phone: String,
    passwordConfirmation: String,
    email: String,
    password: String,
    onNameChange: (String) -> Unit,
    onLastNameChange: (String) -> Unit,
    onPhoneChange: (String) -> Unit,
    onValueChangePasswordConfirmation: (String) -> Unit,
    onValueChangeEmail: (String) -> Unit,
    onValueChangePassword: (String) -> Unit,
    hintName: String,
    hintLastName: String,
    hintEmail: String,
    hintPhone: String,
    hintPassword: String,
    hintPasswordConfirmation: String,
    onConfirm: () -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .height(570.dp),
        shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White.copy(0.7f)),
    ) {
        Text(
            text = stringResource(id = R.string.register).uppercase(),
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 24.dp, top = 14.dp),
            fontSize = 20.sp,
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {

            Textfield(modifier = Modifier
                .fillMaxWidth()
                .align(CenterHorizontally),
                value = name,
                label = hintName,
                icon = Icons.Default.Person,
                tint = Orange80,
                onValueChange ={ onNameChange(it) })
            Textfield(modifier = Modifier
                .fillMaxWidth()
                .align(CenterHorizontally),
                value = lastName,
                label = hintLastName,
                tint = Orange80,
                icon = Icons.Outlined.Person,
                onValueChange = {onLastNameChange(it)})
            Textfield(modifier = Modifier
                .fillMaxWidth()
                .align(CenterHorizontally),
                value = email,
                label = hintEmail,
                tint = Orange80,
                icon = Icons.Default.Email,
                onValueChange = { onValueChangeEmail(it) })
            Textfield(modifier = Modifier
                .fillMaxWidth()
                .align(CenterHorizontally),
                value = phone,
                label = hintPhone,
                tint = Orange80,
                icon = Icons.Default.Phone,
                onValueChange = { onPhoneChange(it) })
            Textfield(modifier = Modifier
                .fillMaxWidth()
                .align(CenterHorizontally),
                value = password,
                label = hintPassword,
                hideText = true,
                tint = Orange80,
                icon = Icons.Default.Lock,
                onValueChange = { onValueChangePassword(it) })
            Textfield(modifier = Modifier
                .fillMaxWidth()
                .align(CenterHorizontally),
                value = passwordConfirmation,
                hideText = true,
                tint = Orange80,
                label = hintPasswordConfirmation,
                icon = Icons.Outlined.Lock,
                onValueChange = { onValueChangePasswordConfirmation(it) })
            Button(
                onClick = onConfirm,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(62.dp)
                    .padding(top = 12.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "Icon")
                Text(
                    text = stringResource(id = R.string.login).uppercase(),
                    modifier = Modifier.padding(start = 12.dp)
                )
            }
        }
    }

}

@Preview
@Composable
fun CardRegisterScreenUIPreview() {
    CardRegisterScreenUI(
        modifier = Modifier,
        hintName = "",
        hintLastName = "",
        hintEmail = "",
        hintPhone = "",
        hintPassword = "",
        hintPasswordConfirmation = "",
        onConfirm = {},
        onValueChangeEmail = {},
        onValueChangePassword = {},
        onValueChangePasswordConfirmation = {},
        onNameChange = {},
        onLastNameChange = {},
        onPhoneChange = {},
        email = "",
        password = "",
        passwordConfirmation = "",
        name = "",
        lastName = "",
        phone = ""
    )
}
