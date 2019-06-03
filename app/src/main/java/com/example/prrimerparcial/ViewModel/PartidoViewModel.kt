package com.example.prrimerparcial.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.prrimerparcial.database.Partido
import com.example.prrimerparcial.database.PartidoRepository
import com.example.prrimerparcial.database.RoomDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PartidoViewModel(app:Application):AndroidViewModel(app) {

    private var repository:PartidoRepository ?= null

    init {
        val partidoDAO = RoomDB.getInstance(getApplication()).partidoDao()
        repository = PartidoRepository(partidoDAO)
    }

    fun insertPartido(partido: Partido) = viewModelScope.launch(Dispatchers.IO) {
        repository!!.insertPartido(partido)
    }

    fun getAllPartido(): LiveData<List<Partido>> = repository!!.getAllPartido()

    fun findPartidoById(id: Int): LiveData<List<Partido>> = repository!!.getPartidoById(id)
}