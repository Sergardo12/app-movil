package com.example.my_app_project.domain.repository

import com.example.my_app_project.domain.model.Servicio

interface ServicioRepository {
    suspend fun obtenerServicios(): List<Servicio>
}