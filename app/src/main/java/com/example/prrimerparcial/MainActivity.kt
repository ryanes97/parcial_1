package com.example.prrimerparcial

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var localnombre: EditText
    private lateinit var visitanombre: EditText
    private lateinit var fecha: EditText
    private lateinit var hora: EditText
    private lateinit var btn_iniciar_partido: Button
    private lateinit var btn_historial: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        localnombre = findViewById(R.id.local)
        visitanombre = findViewById(R.id.visita)
        fecha = findViewById(R.id.fecha)
        hora = findViewById(R.id.hora)
        btn_iniciar_partido = findViewById(R.id.btn_iniciar_partido)
        btn_historial = findViewById(R.id.btn_historial)

        btn_iniciar_partido.setOnClickListener {
            val intent = Intent(this, PartidoActivity::class.java)

            val equipolocal = localnombre.text.toString()
            val equipovisita = visitanombre.text.toString()
            val fechapartido = fecha.text.toString()
            val horapartido = hora.text.toString()

            intent.putExtra("e1",equipolocal)
            intent.putExtra("e2", equipovisita)
            intent.putExtra("fecha", fechapartido)
            intent.putExtra("hora", horapartido)
            startActivity(intent)
        }

        btn_historial.setOnClickListener {
            val intent = Intent(this, ListaPartidosActivity::class.java)
            intent.putExtra("historial", "Partidos Guardados")
        }

    }


}
