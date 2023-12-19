package com.example.eva1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eva1.ui.theme.Eva1Theme
import java.time.format.TextStyle

class HonorarioActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Honorario()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun Honorario() {
    var sueldoBruto by remember { mutableStateOf("")}
    var resultado by remember { mutableStateOf("")}
    val contexto = LocalContext.current
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan)
    ){
        Button(onClick = {
            Log.v("HonoratioActivity", "Volviendo a pantalla principal")
            val intent = Intent(contexto, MainActivity::class.java)
            contexto.startActivity( intent)
        }) {
            Text(text = " <- Volver")
        }
        Text(
            text = "Sueldo Bruto"
        )
        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            placeholder = {Text("Sueldo Bruto")},
            value = sueldoBruto,
            onValueChange = {sueldoBruto = it},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            val s = sueldoBruto.toDouble()
            val sueldoLiquido = EmpleadoHonorarios(s).calcularLiquido()
            resultado = "El sueldo liquido es de ${sueldoLiquido}"
        }) {
            Text("Calcular Sueldo Liquido")
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(resultado)

    }



}

