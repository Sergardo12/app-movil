package com.example.my_app_project.data.repository

import com.example.my_app_project.domain.repository.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.coroutines.tasks.await

class AuthRepositoryImpl(
    private val firebaseAuth : FirebaseAuth
) : AuthRepository {
    override suspend fun iniciarSesionConGoogle(idToken: String): FirebaseUser? {
        val credencial = GoogleAuthProvider.getCredential(idToken, null)
        val authResultado = firebaseAuth.signInWithCredential(credencial).await()
        return authResultado.user
    }

    override fun obtenerUsuarioActual(): FirebaseUser? {
        return firebaseAuth.currentUser
    }

}