package com.example.eva1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class ContratoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contrato)

        val btnVolver = findViewById<Button>(R.id.btnVolver)
        btnVolver.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity( intent )
        }

        val btnCalcularCont = findViewById<Button>(R.id.btnCalcularCont)
        btnCalcularCont.setOnClickListener {
            val resultado = findViewById<TextView>(R.id.tvResultado)

            val sueldoBruto = findViewById<EditText>(R.id.ContSueldoBruto)
            val s = sueldoBruto.text.toString().toDouble()

            val sueldoLiquido = EmpleadoContrato(s).calcularLiquido()
            resultado.text = "El sueldo liquido es ${sueldoLiquido}"

        }
    }
}