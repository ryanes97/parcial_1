package com.example.prrimerparcial.database

import android.content.Context
import android.os.strictmode.InstanceCountViolation
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Partido::class],version = 1,exportSchema = false)
public abstract class RoomDB:RoomDatabase(){

    abstract fun partidoDao():PartidoDAO

    companion object{

        @Volatile
        private var INSTANCE:RoomDB ?= null

        fun getInstance(
            context: Context
        ):RoomDB{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room
                    .databaseBuilder(context,RoomDB::class.java,"PsrtidoDB")
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }


}