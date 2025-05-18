package com.example.my_app_project.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.my_app_project.R
import com.example.my_app_project.domain.model.Servicio

class ServicioAdapter: ListAdapter<Servicio, ServicioAdapter.ServicioViewHolder>(DiffCallback()) {
    inner class ServicioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image = itemView.findViewById<ImageView>(R.id.image_service)
        val text = itemView.findViewById<TextView>(R.id.text_service)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServicioViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.home_item_service, parent, false)
        return ServicioViewHolder(view)
    }

    override fun onBindViewHolder(holder: ServicioViewHolder, position: Int) {
        val item = getItem(position)
        holder.text.text = item.nombreServicio
        Glide.with(holder.itemView.context)
            .load(item.imagenServicio)
            .into(holder.image)
    }

    class DiffCallback : DiffUtil.ItemCallback<Servicio>() {
        override fun areItemsTheSame(oldItem: Servicio, newItem: Servicio) = oldItem.nombreServicio == newItem.nombreServicio
        override fun areContentsTheSame(oldItem: Servicio, newItem: Servicio) = oldItem == newItem
    }
}