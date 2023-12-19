package com.example.eva1

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.eva1.ui.theme.Eva1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PantallaInicio()
        }
    }
}

@Preview
@Composable
fun PantallaInicio(){

    val contexto = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Button(onClick = {
            val intent = Intent(contexto, HonorarioActivity::class.java)
            contexto.startActivity( intent )
        }) {
            Text("Calculo de pago, trabajador a Honorario")
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            val intent = Intent(contexto, ContratoActivity::class.java)
            contexto.startActivity( intent )
        }) {
            Text("Calculo de pago, trabajador a Contrato")
        }
    }
}

abstract class Empleado() {

    abstract fun calcularLiquido() : Double
}
class EmpleadoHonorarios(val sueldoBruto: Double): Empleado() {
    override fun calcularLiquido(): Double = sueldoBruto * (1-0.13)

}
class EmpleadoContrato(val sueldoBruto: Double): Empleado(){
    override fun calcularLiquido(): Double = sueldoBruto * (1-0.2)
}