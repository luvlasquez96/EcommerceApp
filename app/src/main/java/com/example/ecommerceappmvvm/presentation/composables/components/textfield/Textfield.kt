package com.example.ecommerceappmvvm.presentation.composables.components.textfield

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Textfield(
    modifier: Modifier,
    value: String,
    label: String,
    icon: ImageVector,
    hideText: Boolean = false,
    tint: Color? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    onValueChange: (String) -> Unit,
) {
    OutlinedTextField(
        modifier = modifier, value = value, onValueChange = { onValueChange(it) },
        label = { Text(text = label) },
        leadingIcon = { Icon(imageVector = icon, contentDescription = "",
            tint = tint ?: Color.Black
        ) },
        visualTransformation = if (hideText) PasswordVisualTransformation() else VisualTransformation.None,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType)
    )
}