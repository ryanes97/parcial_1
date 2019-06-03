package com.example.prrimerparcial.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Partido")
data class Partido(
    val equipoLocal: String = "N/A",
    val equipoVisitante: String = "N/A",
    val hora: String = "N/A",
    val fecha: String = "N/A",
    val puntosLocal: String = "N/A",
    val puntosVisitante: String = "N/A"
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int=0
}