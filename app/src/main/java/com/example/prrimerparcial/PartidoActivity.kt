package com.example.prrimerparcial

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.prrimerparcial.Adapter.PartidoAdapter
import com.example.prrimerparcial.ViewModel.PartidoViewModel
import com.example.prrimerparcial.database.Partido
import kotlinx.android.synthetic.main.activity_partido.*

class PartidoActivity : AppCompatActivity() {

    private lateinit var localnombre: TextView
    private lateinit var visitanombre: TextView
    private lateinit var totalpuntoslocal: TextView
    private lateinit var totalpuntosvisita: TextView
    private lateinit var fecha: TextView
    private lateinit var hora: TextView
    private lateinit var btn1: Button
    private lateinit var btn2: Button
    private lateinit var btn3: Button
    private lateinit var btn4: Button
    private lateinit var btn5: Button
    private lateinit var btn6: Button
    private lateinit var btn_save: Button

    private val newPartidoActivtyRequestCode = 1
    private lateinit var partidoViewModel: PartidoViewModel

    var puntoslocal = 0
    var puntosvisita = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_partido)

        localnombre =  findViewById(R.id.local)
        visitanombre = findViewById(R.id.visita)
        totalpuntoslocal = findViewById(R.id.puntostotal_local)
        totalpuntosvisita = findViewById(R.id.puntostotal_visita)
        fecha = findViewById(R.id.fechapartido)
        hora = findViewById(R.id.horapartido)
        btn1 = findViewById(R.id.punto1_local)
        btn2 = findViewById(R.id.punto2_local)
        btn3 = findViewById(R.id.punto3_local)
        btn4 = findViewById(R.id.punto1_visita)
        btn5 = findViewById(R.id.punto2_visita)
        btn6 = findViewById(R.id.punto3_visita)
        btn_save = findViewById(R.id.btn_save)

        val extras = intent.extras?: return
        val e1 = extras.getString("e1")
        val e2 = extras.getString("e2")
        val fp = extras.getString("fecha")
        val hp = extras.getString("hora")

        localnombre.text = e1
        visitanombre.text = e2
        fecha.text = fp
        hora.text = hp


        btn1.setOnClickListener { masUnpuntolocal() }
        btn2.setOnClickListener { masDospuntoslocal() }
        btn3.setOnClickListener { masTrespuntoslocal() }
        btn4.setOnClickListener { masUnpuntovisita() }
        btn5.setOnClickListener { masDospuntosvisita() }
        btn6.setOnClickListener { masTrespuntosvisita() }

        btn_save.setOnClickListener {
            val intent = Intent(this,ListaPartidosActivity::class.java)

            val replyIntent = Intent()
            val equipolocal = localnombre.text.toString()
            val equipovisita = visitanombre.text.toString()
            val puntoslocal = totalpuntoslocal.text.toString()
            val puntosvista = totalpuntosvisita.text.toString()
            val fecha = fecha.text.toString()
            val hora = hora.text.toString()
            replyIntent.putExtra(EXTRA_LOCAL,equipolocal)
            replyIntent.putExtra(EXTRA_VISITA,equipovisita)
            replyIntent.putExtra(EXTRA_PUNTAJELOCAL,puntoslocal)
            replyIntent.putExtra(EXTRA_PUNTAJEVISITA,puntosvista)
            replyIntent.putExtra(EXTRA_FECHA, fecha)
            replyIntent.putExtra(EXTRA_HORA, hora)
            setResult(Activity.RESULT_OK, replyIntent)
            startActivityForResult(intent,newPartidoActivtyRequestCode)
            finish()
        }

    }

    companion object{
        const val EXTRA_LOCAL = "local"
        const val EXTRA_VISITA = "visita"
        const val EXTRA_PUNTAJELOCAL = "puntajelocal"
        const val EXTRA_PUNTAJEVISITA = "puntajevisita"
        const val EXTRA_FECHA = "fecha"
        const val EXTRA_HORA = "hora"

    }

    fun masUnpuntolocal(){
        puntoslocal = puntoslocal+1
        mostrarpuntoslocal(puntoslocal) }
    fun masDospuntoslocal(){
        puntoslocal = puntoslocal+2
        mostrarpuntoslocal(puntoslocal) }
    fun masTrespuntoslocal(){
        puntoslocal = puntoslocal+3
        mostrarpuntoslocal(puntoslocal) }
    fun mostrarpuntoslocal(puntaje: Int){
        totalpuntoslocal = findViewById(R.id.puntostotal_local)
        totalpuntoslocal.text = "" + puntaje }
    fun masUnpuntovisita(){
        puntosvisita = puntosvisita+1
        mostrarpuntosvisita(puntosvisita) }
    fun masDospuntosvisita(){
        puntosvisita = puntosvisita+2
        mostrarpuntosvisita(puntosvisita) }
    fun masTrespuntosvisita(){
        puntosvisita = puntosvisita+3
        mostrarpuntosvisita(puntosvisita) }
    fun mostrarpuntosvisita(puntaje: Int){
        totalpuntosvisita = findViewById(R.id.puntostotal_visita)
        totalpuntosvisita.text = "" + puntaje }


}
