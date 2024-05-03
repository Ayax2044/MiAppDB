package com.example.fitnesapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface DAO {
    @Insert
    fun insertpredmet(item: predmet)
    @Query("SELECT * FROM predmets")
    fun getAllpredmet(): Flow<List<predmet>>
}