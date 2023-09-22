package com.example.ecommerceappmvvm.presentation.composables.login

import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommerceappmvvm.presentation.composables.login.model.LoginState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

    var state by mutableStateOf(LoginState())
        private set

    var isValidateState by mutableStateOf(false)
        private set
    var errorMessage by mutableStateOf("")
        private set

    fun onEmailInput(email: String) {
        state = state.copy(email = email)
    }

    fun onPasswordInput(password: String) {
        state = state.copy(password = password)
    }

    fun validState() = viewModelScope.launch{
        if (!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()) {
            errorMessage = "Email inválido"
        }
        else if (state.password.length < 6) {
            errorMessage = "La contraseña debe tener al menos 6 caracteres"
        }
        delay(3000)

        errorMessage = ""
    }
}