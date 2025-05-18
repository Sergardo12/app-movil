package com.example.my_app_project.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.my_app_project.R
import com.example.my_app_project.databinding.FragmentHomeCategoryServicesBinding
import com.example.my_app_project.ui.adapter.ServicioAdapter


class CategoryServicesFragment : Fragment() {
    private var _binding: FragmentHomeCategoryServicesBinding? = null
    private val binding get() = _binding!!

   // private val servicioViewModel: ServicioViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       // val adapter = ServicioAdapter()
       // binding.recyclerServices.adapter = adapter
        //binding.recyclerServices.layoutManager =
           // LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        //servicioViewModel.servicios.observe(viewLifecycleOwner) { servicios ->
           // adapter.submitList(servicios)
        }

       // servicioViewModel.cargarServicios()
    }

   // override fun onDestroy() {
       // super.onDestroy()
        //_binding = null
   // }
   // companion object {

//}
//}