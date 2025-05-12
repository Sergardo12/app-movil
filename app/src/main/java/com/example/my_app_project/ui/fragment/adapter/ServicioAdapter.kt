package com.example.my_app_project.ui.fragment.adapter

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.my_app_project.databinding.ItemServicioBinding
import com.example.my_app_project.domain.model.Servicio
import com.example.my_app_project.R

class ServicioAdapter(private val listaServicios: List<Servicio>) :
    RecyclerView.Adapter<ServicioAdapter.ServicioViewHolder>() {

    private val calificaciones = mutableMapOf<Int, Int>()

    class ServicioViewHolder(val binding: ItemServicioBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServicioViewHolder {
        val binding = ItemServicioBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ServicioViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ServicioViewHolder, position: Int) {
        val servicio = listaServicios[position]

        holder.binding.nombreTrabajador.text = servicio.nombreTrabajador
        holder.binding.especialidad.text = servicio.especialidad
        holder.binding.fecha.text = servicio.fecha

        val promedio = (3..5).random()
        holder.binding.ratingPromedio.rating = promedio.toFloat()

        holder.binding.btnCalificar.setOnClickListener {
            val context = holder.itemView.context
            val inflater = LayoutInflater.from(context)
            val dialogView = inflater.inflate(R.layout.dialog_calificacion, null)

            val ratingBar = dialogView.findViewById<RatingBar>(R.id.ratingBar)
            val txtTitulo = dialogView.findViewById<TextView>(R.id.txtTitulo)
            val btnAceptar = dialogView.findViewById<Button>(R.id.btnAceptar)

            txtTitulo.text = "Calificar a ${servicio.nombreTrabajador}"

            val dialog = AlertDialog.Builder(context)
                .setView(dialogView)
                .create()

            btnAceptar.setOnClickListener {
                val calificacion = ratingBar.rating.toInt()
                Toast.makeText(context, "Calificación: $calificacion estrellas", Toast.LENGTH_SHORT).show()

                holder.binding.btnCalificar.isEnabled = false
                holder.binding.btnCalificar.text = "Calificado"

                dialog.dismiss()
            }

            dialog.show()
        }
    }
    override fun getItemCount(): Int = listaServicios.size
}

