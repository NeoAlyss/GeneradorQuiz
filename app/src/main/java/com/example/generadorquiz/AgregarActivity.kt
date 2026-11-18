package com.example.generadorquiz

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AgregarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_agregar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edtCantPreguntas = findViewById<EditText>(R.id.edtCantPreguntasAgregar)
        val btnRestar = findViewById<Button>(R.id.btnRestarPreguntasAgregar)
        val btnSumar = findViewById<Button>(R.id.btnSumarPreguntasAgregar)

        btnRestar?.setOnClickListener {
            val valorActual = edtCantPreguntas?.text.toString().toIntOrNull() ?: 1
            if (valorActual > 1) {
                edtCantPreguntas?.setText((valorActual - 1).toString())
            }
        }

        btnSumar?.setOnClickListener {
            val valorActual = edtCantPreguntas?.text.toString().toIntOrNull() ?: 1
            edtCantPreguntas?.setText((valorActual + 1).toString())
        }
    }
}