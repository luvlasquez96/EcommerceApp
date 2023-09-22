package com.example.ecommerceappmvvm.presentation.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.ecommerceappmvvm.presentation.composables.register.RegisterScreenUI
import com.example.ecommerceappmvvm.presentation.navigation.screen.AuthScreen
import com.example.ecommerceappmvvm.presentation.navigation.screen.Graph
import com.example.ecommerceappmvvm.presentation.composables.login.LoginScreenUI

fun NavGraphBuilder.AuthNavGraph(
    navController: NavHostController
) {
    navigation(
        route = Graph.AUTH,
        startDestination = AuthScreen.Login.route
    ){
        composable(route= AuthScreen.Login.route){
            LoginScreenUI(navController)
        }
        composable(route = AuthScreen.Register.route){
            RegisterScreenUI(navController)
        }
    }
}