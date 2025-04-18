package com.example.my_app_project

import android.os.Bundle
import android.text.InputType
import android.text.method.PasswordTransformationMethod
import android.widget.EditText
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FormInicioSesion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_form_inicio_sesion)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val password =findViewById<EditText>(R.id.password)
        val btnMostrarContraseña = findViewById<ImageButton>(R.id.btnMostrarContraseña)
        var ContraseñaVisible = false

        btnMostrarContraseña.setOnClickListener{
            ContraseñaVisible = !ContraseñaVisible
            if (ContraseñaVisible) {
                password.transformationMethod = null
                btnMostrarContraseña.setBackgroundResource(R.drawable.ojoabierto)
            }else{
                password.transformationMethod = PasswordTransformationMethod.getInstance()
                btnMostrarContraseña.setBackgroundResource(R.drawable.ojocerrado)
            }
            password.setSelection(password.text.length)
        }
    }
}