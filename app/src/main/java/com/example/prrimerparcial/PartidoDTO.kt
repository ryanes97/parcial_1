package com.example.prrimerparcial

import android.os.Parcel
import android.os.Parcelable

class PartidoDTO(
    val equipoLocal: String = "N/A",
    val equipoVisitante: String = "N/A",
    val hora: String = "N/A",
    val fecha: String = "N/A",
    val puntosLocal: String = "N/A",
    val puntosVisitante: String = "N/A"
):Parcelable {
    constructor(parcel: Parcel): this(
          parcel.readString(),
          parcel.readString(),
          parcel.readString(),
          parcel.readString(),
          parcel.readString(),
          parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(equipoLocal)
        parcel.writeString(equipoVisitante)
        parcel.writeString(hora)
        parcel.writeString(fecha)
        parcel.writeString(puntosLocal)
        parcel.writeString(puntosVisitante)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PartidoDTO> {
        override fun createFromParcel(parcel: Parcel): PartidoDTO {
            return PartidoDTO(parcel)
        }

        override fun newArray(size: Int): Array<PartidoDTO?> {
            return arrayOfNulls(size)
        }
    }
}