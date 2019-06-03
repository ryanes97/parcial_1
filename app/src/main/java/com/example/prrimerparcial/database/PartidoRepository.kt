package com.example.prrimerparcial.database

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData

class PartidoRepository(private val partidoDAO: PartidoDAO) {

    fun getPartidoById(id: Int): LiveData<List<Partido>> = partidoDAO.getPartidoById(id)

    fun getAllPartido(): LiveData<List<Partido>> = partidoDAO.getAllPartido()

    fun deleteAll() = partidoDAO.deleteall()

    @WorkerThread
    suspend fun insertPartido(partido: Partido) = partidoDAO.insertPartido(partido)
}