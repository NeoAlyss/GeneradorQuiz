package com.example.generadorquiz

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class IAActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_iaactivity)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edtCantPreguntas = findViewById<EditText>(R.id.edtCantPreguntasIA)
        val btnRestar = findViewById<Button>(R.id.btnRestarPreguntasIA)
        val btnSumar = findViewById<Button>(R.id.btnSumarPreguntasIA)

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