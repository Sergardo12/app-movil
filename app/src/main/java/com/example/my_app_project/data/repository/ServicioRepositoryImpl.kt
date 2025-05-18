package com.example.my_app_project.data.repository

import com.example.my_app_project.domain.model.Servicio
import com.example.my_app_project.domain.repository.ServicioRepository
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class ServicioRepositoryImpl( private val firestore: FirebaseFirestore) : ServicioRepository {
    override suspend fun obtenerServicios(): List<Servicio> {
        val snapshot = firestore.collection("servicios").get().await()
        return snapshot.documents.mapNotNull {
            doc -> doc.toObject(Servicio::class.java)
        }
    }


}