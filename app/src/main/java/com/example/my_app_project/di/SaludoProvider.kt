package com.example.my_app_project.di

import javax.inject.Inject

class SaludoProvider @Inject constructor() {
    fun obtenerSaludo(): String = "Hola desde Hilt"
}