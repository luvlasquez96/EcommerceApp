package com.example.ecommerceappmvvm.presentation.composables.register.model

data class RegisterStatus(
    val email: String = "",
    val password: String = "",
    val name: String = "",
    val lastName: String = "",
    val phone: String = "",
    val passwordConfirmation: String = "",
)
