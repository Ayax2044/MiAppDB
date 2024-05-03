package com.example.fitnesapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [predmet::class], version = 1)
abstract class MainDatBas : RoomDatabase(){

    //выдаёт базу данных
    abstract fun getDaO(): DAO
    companion object{
        fun getDaBa(context: Context): MainDatBas {
            return Room.databaseBuilder(
                context.applicationContext,
                MainDatBas::class.java,
                "test_database.db"
            ).build()
        }
    }
}