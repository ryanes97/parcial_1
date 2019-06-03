package com.example.prrimerparcial

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.prrimerparcial.Adapter.PartidoAdapter
import com.example.prrimerparcial.ViewModel.PartidoViewModel
import com.example.prrimerparcial.database.Partido
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_partido.*

class ListaPartidosActivity : AppCompatActivity() {

    private val newPartidoActivityRequestCode = 1
    private lateinit var partidoViewModel: PartidoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_partidos)

        val extras = intent.extras?: return
        val x = extras.getString("historial")

        val recyclerView = findViewById<RecyclerView>(R.id.partidos_rv)
        val adapter = PartidoAdapter(this)
        recyclerView.adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        partidoViewModel = ViewModelProviders.of(this).get(PartidoViewModel::class.java)

        val partidos: LiveData<List<Partido>> = partidoViewModel.getAllPartido()

        partidoViewModel.getAllPartido().observe(this, Observer { partidos -> partidos?.let { adapter.setPartidos(it) } })

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            val intent = Intent(this@ListaPartidosActivity, PartidoActivity::class.java)
            startActivityForResult(intent, newPartidoActivityRequestCode)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == newPartidoActivityRequestCode && resultCode == Activity.RESULT_OK){
            data?.let{
               val partido = Partido(it.getStringExtra(PartidoActivity.EXTRA_LOCAL),
                                     it.getStringExtra(PartidoActivity.EXTRA_VISITA),
                                     it.getStringExtra(PartidoActivity.EXTRA_FECHA),
                                     it.getStringExtra(PartidoActivity.EXTRA_HORA),
                                     it.getStringExtra(PartidoActivity.EXTRA_PUNTAJELOCAL),
                                     it.getStringExtra(PartidoActivity.EXTRA_PUNTAJEVISITA))

                partidoViewModel.insertPartido(partido)
            }
        }else{
            Toast.makeText(
                applicationContext,
                "esta vacio",
                Toast.LENGTH_LONG).show()

        }
    }


}
