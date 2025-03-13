package mx.edu.itson.potros.examenu2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Principal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)
        val btnDetalles: Button = findViewById(R.id.btnDetalles)
        val btnGlobos: Button = findViewById(R.id.btnGlobos)
        val btnPeluches: Button = findViewById(R.id.btnPeluches)
        val btnRegalos: Button = findViewById(R.id.btnRegalos)
        val btnTazas: Button = findViewById(R.id.btnTazas)

        btnDetalles.setOnClickListener {
            var intent: Intent = Intent(this, Regalos::class.java)
            intent.putExtra("tipo", "detalles")
            startActivity(intent)
        }

        btnGlobos.setOnClickListener {
            var intent: Intent = Intent(this, Regalos::class.java)
            intent.putExtra("tipo", "globos")
            startActivity(intent)
        }

        btnPeluches.setOnClickListener {
            var intent: Intent = Intent(this, Regalos::class.java)
            intent.putExtra("tipo", "peluches")
            startActivity(intent)
        }

        btnRegalos.setOnClickListener {
            var intent: Intent = Intent(this, Regalos::class.java)
            intent.putExtra("tipo", "regalos")
            startActivity(intent)
        }

        btnTazas.setOnClickListener {
            var intent: Intent = Intent(this, Regalos::class.java)
            intent.putExtra("tipo", "tazas")
            startActivity(intent)
        }


    }
}