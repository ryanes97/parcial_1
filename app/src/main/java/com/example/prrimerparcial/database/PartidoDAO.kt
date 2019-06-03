package com.example.prrimerparcial.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PartidoDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPartido(partido: Partido)

    @Query("SELECT * FROM Partido" )
    fun getAllPartido(): LiveData<List<Partido>>

    @Query("SELECt * FROM Partido WHERE id LIKE :id")
    fun getPartidoById(id: Int): LiveData<List<Partido>>

    @Query("DELETE FROM Partido")
    fun deleteall()

}