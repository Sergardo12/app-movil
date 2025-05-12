package com.example.my_app_project.ui.fragment.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.my_app_project.domain.model.Servicio
import com.example.my_app_project.ui.fragment.adapter.ServicioAdapter
import com.example.my_app_project.databinding.FragmentHistoryBinding

class HistoryFragment : Fragment() {

    private lateinit var binding: FragmentHistoryBinding
    private lateinit var servicioAdapter: ServicioAdapter
    private lateinit var listaHistorial: MutableList<Servicio>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHistoryBinding.inflate(inflater, container, false)

        listaHistorial = mutableListOf(
            Servicio("Gasfitero", "Luis R.", "06/04/2025"),
            Servicio("Electricista", "Juan T.", "03/04/2025"),
            Servicio("Carpintero", "Pedro Z.", "01/04/2025")
        )

        servicioAdapter = ServicioAdapter(listaHistorial)
        binding.recyclerHistorial.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerHistorial.adapter = servicioAdapter

        return binding.root
    }
}
