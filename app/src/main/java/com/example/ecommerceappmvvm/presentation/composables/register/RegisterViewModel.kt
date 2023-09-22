package com.example.ecommerceappmvvm.presentation.composables.register

import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommerceappmvvm.presentation.composables.register.model.RegisterStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@HiltViewModel
class RegisterViewModel @Inject constructor() : ViewModel() {

    var state by mutableStateOf(RegisterStatus())
        private set

    var errorMessage by mutableStateOf("")
        private set

    fun onEmailInput(email: String) {
        state = state.copy(email = email)
    }

    fun onPasswordInput(password: String) {
        state = state.copy(password = password)
    }

    fun onNameInput(name: String) {
        state = state.copy(name = name)
    }

    fun onLastNameInput(lastName: String) {
        state = state.copy(lastName = lastName)
    }

    fun onPhoneInput(phone: String) {
        state = state.copy(phone = phone)
    }

    fun onPasswordConfirmationInput(passwordConfirmation: String) {
        state = state.copy(passwordConfirmation = passwordConfirmation)
    }

    fun validState() = viewModelScope.launch {
        if (state.name == "") {
            errorMessage = "Ingrese el nombre"
        } else if (state.lastName == "") {
            errorMessage = "Ingrese el apellido"
        }else if (state.email == "") {
            errorMessage = "Ingrese el email"
        }else if (state.phone == "") {
            errorMessage = "Ingrese el teléfono"
        } else if (state.password == "") {
            errorMessage = "Ingrese la contraseña"
        }else if (state.passwordConfirmation == "") {
            errorMessage = "Ingrese la confirmación de la contraseña"
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()) {
            errorMessage = "Email inválido"
        } else if (state.password.length < 6) {
            errorMessage = "La contraseña debe tener al menos 6 caracteres"
        } else if (state.password != state.passwordConfirmation) {
            errorMessage = "Las contraseñas no coinciden"
        }
        delay(3000)

        errorMessage = ""
    }
}