package com.example.my_app_project

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // Enlazar vistas
        val nombreTextView = findViewById<TextView>(R.id.NombreProveedor)
        val profesionTextView = findViewById<TextView>(R.id.ProfesionProveedor)
        val telefonoTextView = findViewById<TextView>(R.id.phoneTextView)
        val emailTextView = findViewById<TextView>(R.id.emailTextView)
        val calificacionTextView = findViewById<TextView>(R.id.ratingTextView)
        val ubicacionTextView = findViewById<TextView>(R.id.Ciudad)
        val descripcionTextView = findViewById<TextView>(R.id.DescripcionProveedor)

        val estadisticasButton = findViewById<Button>(R.id.EstadisticasProveedor)
        val opinionesButton = findViewById<Button>(R.id.OpinionesProveedor)

        // Acciones de los botones
        estadisticasButton.setOnClickListener {
            Toast.makeText(this, "Mostrando estadísticas (no implementado)", Toast.LENGTH_SHORT).show()
            // Aquí puedes lanzar una nueva actividad o mostrar un fragmento
        }

        opinionesButton.setOnClickListener {
            Toast.makeText(this, "Mostrando opiniones (no implementado)", Toast.LENGTH_SHORT).show()
            // Igual, aquí podrías abrir otra pantalla
        }

        // Puedes también cambiar dinámicamente los valores desde código
        // nombreTextView.text = "Otro nombre dinámico"
    }
}