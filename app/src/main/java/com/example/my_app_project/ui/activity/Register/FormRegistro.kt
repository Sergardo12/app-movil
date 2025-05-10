package com.example.my_app_project.ui.activity.Register

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.my_app_project.R

class FormRegistro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_form_registro)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //Boton Cliente
        val btnCliente = findViewById<Button>(R.id.btnCliente)
        btnCliente.setOnClickListener{
            val intento = Intent(this, FormRegisCliente::class.java)
            startActivity(intento)
        }

        //Boton Trabajador
        val btnTrabajador = findViewById<Button>(R.id.btnTrabajador)
        btnTrabajador.setOnClickListener{
            val intento = Intent(this, FormRegisTrabajador::class.java)
            startActivity(intento)
        }
    }
}