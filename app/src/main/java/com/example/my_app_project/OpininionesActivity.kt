import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.my_app_project.R

class OpinionesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opiniones)
    val verOpinionesBtn = findViewById<Button>(R.id.btnVerOpiniones)
    val escribirOpinionBtn = findViewById<Button>(R.id.btnEscribirOpinion)

    // Simulando que cargaste estas calificaciones desde Firebase o base de datos local
    val listaCalificaciones = listOf(5f, 4f, 4.5f, 3f, 5f)  // <-- reemplaza por los datos reales

    val promedio = calcularPromedio(listaCalificaciones)

    // Ahora puedes mostrar este promedio en el perfil del trabajador
    val promedioTextView = findViewById<TextView>(R.id.ratingTextView)
    promedioTextView.text = promedio.toString()
}

// Función para calcular el promedio
private fun calcularPromedio(calificaciones: List<Float>): Float {
    return if (calificaciones.isNotEmpty()) {
        calificaciones.sum() / calificaciones.size
    } else 0f
 }
}