package com.example.my_app_project.presentation.autenticacion

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.my_app_project.domain.repository.AuthRepository
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _usuarioActual = MutableStateFlow<FirebaseUser?>(null)
    val usuarioActual: StateFlow<FirebaseUser?> = _usuarioActual

    fun iniciarSesionConGoogle(idToken: String){
        viewModelScope.launch {
            val user = authRepository.iniciarSesionConGoogle(idToken)
            _usuarioActual.value = user
        }
    }

    fun obtenerUsuarioActual(){
        _usuarioActual.value = authRepository.obtenerUsuarioActual()
    }
}