package com.example.my_app_project.presentation.servicio

import androidx.lifecycle.ViewModel
import com.example.my_app_project.domain.model.Servicio
import com.example.my_app_project.domain.repository.ServicioRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import androidx.lifecycle.viewModelScope


class ServicioViewModel(private val repository: ServicioRepository) : ViewModel() {
    private val _servicios = MutableStateFlow<List<Servicio>>(emptyList())
    val servicios: StateFlow<List<Servicio>> = _servicios

    //fun cargarServicios() {
        //viewModelScope.launch {
        //    val data = repository.obtenerServicios()
          //  _servicios.value = data
       // }
   // }
}