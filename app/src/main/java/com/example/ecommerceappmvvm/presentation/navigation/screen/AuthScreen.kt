package com.example.ecommerceappmvvm.presentation.navigation.screen

sealed class AuthScreen(val route: String){
    object Login: AuthScreen("login")
    object Register: AuthScreen("register")
}

