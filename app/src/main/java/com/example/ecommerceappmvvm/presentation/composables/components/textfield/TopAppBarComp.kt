package com.example.ecommerceappmvvm.presentation.composables.components.textfield

import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarComp(
    navController: NavHostController? = null,
    title: String,
    isIconAvailable: Boolean = false
) {

    TopAppBar(title = {
        Text(
            text = title.uppercase(),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
        )
    },
        modifier = Modifier.background(Color.White),
        navigationIcon = { if (isIconAvailable)
            IconButton(onClick = { navController?.popBackStack() }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "back",
                    tint = Color.Black
                )
            }
        },
    )
}