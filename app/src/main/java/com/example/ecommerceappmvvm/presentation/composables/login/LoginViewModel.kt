package com.example.ecommerceappmvvm.presentation.composables.login

import android.util.Log
import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommerceappmvvm.domain.model.User
import com.example.ecommerceappmvvm.domain.model.repository.Response
import com.example.ecommerceappmvvm.domain.model.repository.usecase.auth.AuthUsecase
import com.example.ecommerceappmvvm.presentation.composables.login.model.LoginState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@HiltViewModel
class LoginViewModel @Inject constructor(private val authUsecase: AuthUsecase) : ViewModel() {

    var state by mutableStateOf(LoginState())
        private set

    var isValidateState by mutableStateOf(false)
        private set
    var errorMessage by mutableStateOf("")
        private set

    var loginResponse by mutableStateOf<Response<User>?>(null)
        private set

    fun onEmailInput(email: String) {
        state = state.copy(email = email)
    }

    fun onPasswordInput(password: String) {
        state = state.copy(password = password)
    }

    fun isValidState(): Boolean {
        if (!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()) {
            errorMessage = "Email inválido"
            return false
        }
        else if (state.password.length < 6) {
            errorMessage = "La contraseña debe tener al menos 6 caracteres"
            return false
        }
        return true
    }

    fun login() = viewModelScope.launch{
        if(isValidState()) {
            loginResponse = Response.Loading//esperando
            val result = authUsecase.login(state.email, state.password)//retorna una respuesta
            loginResponse = result// exitosa o fallida
            Log.d("LoginViewModel", "Response: $loginResponse")
        }
    }
}