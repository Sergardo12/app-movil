package com.example.my_app_project.data.repository

import com.example.my_app_project.domain.model.Categoria
import com.example.my_app_project.domain.repository.CategoriaRepository
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.toObject
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class CategoriaRepositoryImpl @Inject constructor(
    private val firestore: FirebaseFirestore
) : CategoriaRepository {

    override fun obtenerCategorias(): Flow<List<Categoria>> = callbackFlow {
        val collection = firestore.collection("categorias")
        val listener = collection.addSnapshotListener{ snapshot, error ->
            if (error != null){
                close(error)
                return@addSnapshotListener
            }
            val listaCategorias = snapshot?.documents?.mapNotNull { doc ->
                doc.toObject(Categoria::class.java)
            } ?: emptyList()
            trySend(listaCategorias)
        }
        awaitClose{listener.remove()}
    }
}