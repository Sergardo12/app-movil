package com.example.my_app_project

import OpinionesActivity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PerfilActivity : AppCompatActivity() {

    private val telefono = "+51997778521"
    private val email = "JuanPerez44@example.com"
    private val nombreProveedor = "Juan Perez"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfilpublicotrab)

        val btnMensaje: Button = findViewById(R.id.btnMensaje)
        val btnLlamar: Button = findViewById(R.id.btnLlamar)
        val btnEmail: Button = findViewById(R.id.btnEmail)
        val btnVolver: ImageButton = findViewById(R.id.backButton)
        val btnOpiniones: Button = findViewById(R.id.OpinionesProveedor)

        btnOpiniones.setOnClickListener {
            val intent = Intent(this, OpinionesActivity::class.java)
            startActivity(intent)
        }

        btnMensaje.setOnClickListener {
            val uri = Uri.parse("smsto:$telefono")
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            startActivity(intent)
        }

        btnLlamar.setOnClickListener {
            val uri = Uri.parse("tel:$telefono")
            val intent = Intent(Intent.ACTION_DIAL, uri) // Usa ACTION_CALL si deseas marcar directamente (requiere permiso)
            startActivity(intent)
        }

        btnEmail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
                putExtra(Intent.EXTRA_SUBJECT, "Consulta para $nombreProveedor")
            }
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                Toast.makeText(this, "No hay app de correo instalada", Toast.LENGTH_SHORT).show()
            }
        }

        btnVolver.setOnClickListener {
            finish() // Cierra esta Activity y vuelve a la anterior
        }
    }
}
